package gr.ds.restapi.controller;

import gr.ds.restapi.dao.UserDAO;
import gr.ds.restapi.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddCitizenController {

    @Autowired
    private UserDAO<Citizen> citizenDAO;

    @Autowired
    private UserDAO<Admin> adminDAO;

    @Autowired
    private UserDAO<CivicOfficial> civicDAO;


    @GetMapping("/add-citizen")
    public String addCitizen(){


        return "done";
    }

    @GetMapping("/delete-citizen")
    public String deleteCitizen(){

        return "done";
    }

    @GetMapping("/update-citizen")
    public String updateCitizen(){

        Citizen citizen = new Citizen(2, "user2", "user$2", "User 2", "region2", 1, "address 2", 22222, "user2@gmail.com");



        return "done";
    }


    @GetMapping("/add-citizens")
    public String addCitizens(){

        Citizen citizen1 = new Citizen(11, "user1", "user", "User 1", "region1", 1, "dwada", 9087987, "dadada");
        citizen1.addRole(new Role("ROLE_USR"));
        citizenDAO.addUser(citizen1);
        Citizen citizen2 = new Citizen(12, "user2", "user", "User 2", "region2", 1, "dwada", 9087987, "dadada");
        citizen2.addRole(new Role("ROLE_USR"));
        citizenDAO.addUser(citizen2);
        Citizen citizen3 = new Citizen(13, "user3", "user", "User 3", "region3", 1, "dwada", 9087987, "dadada");
        citizen3.addRole(new Role("ROLE_USR"));
        citizenDAO.addUser(citizen3);
        Citizen citizen4 = new Citizen(14, "user4", "user", "User 4", "region4", 1, "dwada", 9087987, "dadada");
        citizen4.addRole(new Role("ROLE_USR"));
        citizenDAO.addUser(citizen4);
        return "done";

    }

    @GetMapping("/add-civics")
    public String addCivs(){

        CivicOfficial citizen1 = new CivicOfficial(33000, "user1", "user", "User 1", "region1", 1);
        citizen1.addRole(new Role("ROLE_CVC"));
        citizen1.addRole(new Role("ROLE_MNG"));
        civicDAO.addUser(citizen1);
        CivicOfficial citizen2 = new CivicOfficial(66667, "user2", "user", "User 2", "region2", 1);
        citizen2.addRole(new Role("ROLE_CVC"));
        civicDAO.addUser(citizen2);
        CivicOfficial citizen3 = new CivicOfficial(77778, "user3", "user", "User 3", "region3", 1);
        citizen3.addRole(new Role("ROLE_CVC"));
        civicDAO.addUser(citizen3);
        CivicOfficial citizen4 = new CivicOfficial(8889, "user4", "user", "User 4", "region4", 1);
        citizen4.addRole(new Role("ROLE_CVC"));
        civicDAO.addUser(citizen4);

        return "done";

    }

    @GetMapping("/add-root")
    public String addRoot(){
        Admin user = new Admin(0, "root", "$2a$12$n.RnsPqyWjde63fhkghVNOr3J1LZadWxm49Kskqcr2nlmuWOBxxDG", "", "", 1);
        user.addRole(new Role("ROLE_ADMIN"));
        adminDAO.addUser(user);

        return "admin added";
    }
}
