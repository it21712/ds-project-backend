package gr.ds.restapi.controller;

import gr.ds.restapi.dao.UserDAO;
import gr.ds.restapi.entity.Citizen;
import gr.ds.restapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddCitizenController {

    @Autowired
    private UserDAO<Citizen> citizenDAO;

    @Autowired
    private UserDAO<User> adminDAO;

    @GetMapping("/add-citizen")
    public String addCitizen(){


        return "done";
    }

    @GetMapping("/delete-citizen")
    public String deleteCitizen(){
        citizenDAO.deleteUser(3);
        return "done";
    }

    @GetMapping("/update-citizen")
    public String updateCitizen(){

        Citizen citizen = new Citizen(2, "user2", "user$2", "User 2", "region2", 1, "address 2", 22222, "user2@gmail.com");

        citizenDAO.updateUser(citizen);

        return "done";
    }

    @GetMapping("/add-citizens")
    public String addCitizens(){

        Citizen citizen1 = new Citizen(1, "user1", "user", "User 1", "region1", 1, "address 1", 11111, "user1@gmail.com");
        citizenDAO.addUser(citizen1);
        Citizen citizen2 = new Citizen(2, "user2", "user", "User 2", "region2", 1, "address 2", 22222, "user2@gmail.com");
        citizenDAO.addUser(citizen2);
        Citizen citizen3 = new Citizen(3, "user3", "user", "User 3", "region3", 1, "address 3", 33333, "user3@gmail.com");
        citizenDAO.addUser(citizen3);
        Citizen citizen4 = new Citizen(4, "user4", "user", "User 4", "region4", 1, "address 4", 44444, "user4@gmail.com");
        citizenDAO.addUser(citizen4);

        return "done";

    }

    @GetMapping("/add-root")
    public String addRoot(){
        User user = new User(0, "root", "$2a$12$n.RnsPqyWjde63fhkghVNOr3J1LZadWxm49Kskqcr2nlmuWOBxxDG", "", "", 1);

        adminDAO.addUser(user);

        return "admin added";
    }
}
