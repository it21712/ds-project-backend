package gr.ds.restapi.controller;

import com.google.gson.Gson;
import gr.ds.restapi.dao.EntityDAO;
import gr.ds.restapi.entity.MedicalHistory;
import gr.ds.restapi.entity.Pet;
import gr.ds.restapi.entity.Vet;
import gr.ds.restapi.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vet")
public class VetController {

    @Autowired
    EntityDAO<Vet> vetDAO;

    @Autowired
    EntityDAO<Pet> petDAO;

    @Autowired
    PetService petService;

    @GetMapping("/home")
    public String info(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        String username = auth.getName();

        Vet vet = vetDAO.getEntity(username);


        String json = new Gson().toJson(vet);

        return json;
    }

    @PostMapping("/show-pending")
    public String showPending(@RequestBody String citizenName){

        List<Pet> pendingPets = petService.getPendingPetsByCitizenName(citizenName);

        String json = new Gson().toJson(pendingPets);

        return json;
    }

    @PostMapping("/verify-pet")
    public String verifyPet(@RequestBody String petSerialNum){

        int serialNum = Integer.parseInt(petSerialNum);

        Pet pet = petService.getById(serialNum);
        System.out.println("pet pending: " + pet.getIs_approved());
        pet.setIs_approved(1);
        System.out.println("pet pending: " + pet.getIs_approved());
        petService.verifyPet(pet.getSerialNumber());

        Pet petResponse = new Pet(pet.getSerialNumber(), pet.getOwnerCode(), pet.getType(), pet.getRace(), pet.getSex(), pet.getBirthDate(), pet.getIs_approved());

        return new Gson().toJson(petResponse, Pet.class);
    }


    @PostMapping("/update-med-history")
    public String updatePetHistory(@RequestBody MedicalHistory medOp){

        Pet pet = petService.getById(medOp.getPetNumber());

        if(pet.getIs_approved() == 0){
            return "Pet with serial number: " + pet.getSerialNumber()+ " is not verified.\nPlease verify it first and then update its medical history";
        }
        medOp.setPet(pet);

        pet.addMedicalOp(medOp);

        petDAO.updateEntity(pet);

        return medOp.getOperation();

    }


}
