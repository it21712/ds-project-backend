package gr.ds.restapi.controller;

import com.google.gson.Gson;
import gr.ds.restapi.dao.PetRepository;
import gr.ds.restapi.dao.EntityDAO;
import gr.ds.restapi.entity.CivicOfficial;
import gr.ds.restapi.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/civic")
public class CivicController {

    @Autowired
    EntityDAO<CivicOfficial> civicDAO;

    @Autowired
    PetRepository petRepository;

    @GetMapping("/home")
    public String info(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        String username = auth.getName();

        CivicOfficial civic = civicDAO.getUser(username);

        String json = new Gson().toJson(civic);

        return json;
    }

    @GetMapping("/show-pets")
    public String showPets(){

        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        String username = auth.getName();

        CivicOfficial civic = civicDAO.getUser(username);

        List<Pet> pets = petRepository.getPetsByRegion(civic.getRegion());

        String json = new Gson().toJson(pets);

        return json;

    }
}
