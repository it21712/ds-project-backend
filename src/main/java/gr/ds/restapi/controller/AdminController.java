package gr.ds.restapi.controller;


import gr.ds.restapi.dao.EntityDAO;
import gr.ds.restapi.dao.UserRepository;
import gr.ds.restapi.entity.*;
import gr.ds.restapi.services.CitizenService;
import gr.ds.restapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
@RequestMapping("/api/root/users")
public class AdminController {


    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    EntityDAO<Citizen> citizenDAO;

    @Autowired
    static EntityDAO<Vet> vetDAO;

    @Autowired
    static EntityDAO<CivicOfficial> civicDAO;

    @Autowired
    UserService userService;



    @GetMapping("/{usertype}/all")
    public String listCitizens(@PathVariable String usertype, Model model){


        System.out.println(usertype);
        switch (usertype){
            case "citizens":
                List<Citizen> citizens = citizenDAO.showALl();
                model.addAttribute("citizens", citizens);
                break;
            case "vets":
                List<Vet> vets = vetDAO.showALl();
                model.addAttribute("citizens", vets);
                break;

            case "civis":
                List<CivicOfficial> civis = civicDAO.showALl();
                model.addAttribute("citizens", civis);
                break;
            default:
                break;
        }

        return "list-citizens";

    }

    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable String username){

        userService.deleteUserByUsername(username);
        return "success-form";
    }

    //Citizen section

    @Autowired
    CitizenService citizenService;



    @GetMapping("/add-citizen")

    public String addCitizen(Model model){

        model.addAttribute("citizen", new Citizen());
        return "citizen-add-form";
    }
    @PostMapping("/add-citizen")
    public String addCitizenSubmit(@ModelAttribute Citizen citizen){

        System.out.println("id: "+citizen.getId());
        citizen.addRole(new Role("ROLE_CITIZEN"));
        citizenDAO.addEntity(citizen);

        return "success-form";
    }


    @GetMapping("/update-citizen/{code}")
    public String updateCitizen(@PathVariable int code, Model model){

        Citizen citizen = citizenService.getFullCitizenByCode(code);
        System.out.println(citizen.getId());
        model.addAttribute("citizen", citizen);
        return "citizen-update-form";
    }
    @PostMapping("/update-citizen/{code}")
    public String updateCitizenSubmit(@ModelAttribute Citizen citizen){ //TODO add roles to add citizen and update citizen

        citizen.addRole(new Role("ROLE_CITIZEN"));
        citizenDAO.updateEntity(citizen);

        return "success-form";
    }




}

