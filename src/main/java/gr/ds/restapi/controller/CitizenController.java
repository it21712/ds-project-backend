package gr.ds.restapi.controller;

import com.google.gson.Gson;

import gr.ds.restapi.dao.EntityDAO;
import gr.ds.restapi.entity.Citizen;
import gr.ds.restapi.entity.Pet;
import gr.ds.restapi.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/citizen")
public class CitizenController {

    //Authentication auth = SecurityContextHolder.getContext().getAuthentication();


    @Autowired
    EntityDAO<Citizen> citizenDAO;

    /*@Autowired
    IPetService petService;*/

    @Autowired
    PetService petService;

    @GetMapping("/home")
    public String CitizenInfo(){

        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        String username = auth.getName();

        Citizen citizen = citizenDAO.getEntity(username);

        String json = new Gson().toJson(citizen);

        return json;
    }

    @PostMapping("/add-pet") //TODO fix empty json request
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addPet(@RequestBody Pet pet){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        String username = auth.getName();

        Citizen citizen = citizenDAO.getEntity(username);
        pet.setCitizen(citizen);
        citizen.addPet(pet);
        citizenDAO.updateEntity(citizen);
        return new ResponseEntity<>(pet.getSerialNumber(), HttpStatus.CREATED);
    }

    @GetMapping("/pets")
    public String Pets(){

        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        String username = auth.getName();

        List<Pet> pets = petService.getPetsByCitizenName(username);

        String json = new Gson().toJson(pets);

        return json;

    }

    @GetMapping("/pending-pets")
    public String pendingPets(){

        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        String username = auth.getName();

        List<Pet> pets = petService.getPendingPetsByCitizenName(username);

        String json = new Gson().toJson(pets);

        return json;

    }




}
