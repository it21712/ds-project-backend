package gr.ds.restapi.controller;

import com.google.gson.Gson;

import gr.ds.restapi.dao.UserDAO;
import gr.ds.restapi.entity.Citizen;
import gr.ds.restapi.entity.Pet;
import gr.ds.restapi.services.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
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
    UserDAO<Citizen> citizenDAO;

    @Autowired
    IPetService petService;

    @GetMapping("/home")
    public String CitizenInfo(){

        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        String username = auth.getName();

        Citizen citizen = citizenDAO.getUser(username);

        String json = new Gson().toJson(citizen);

        return json;
    }

    @PostMapping(value = "/add", consumes = "application/json")
    @ResponseBody
    public String addPet(){

        return "";
    }


    @GetMapping("/add-pet")
    public String add(){

        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        String username = auth.getName();

        Citizen citizen = citizenDAO.getUser(username);
        /*Pet pet = new Pet(1216, citizen, "type1", "race1", "sex1", "date1", 0);
        petRepository.addPet(pet);*/
        citizen.addPet(new Pet(1111, citizen, "type1", "race1", "sex1", "date1", 1));
        citizenDAO.updateUser(citizen);
        return "pet ok";
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
