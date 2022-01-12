package gr.ds.restapi.controller;

import gr.ds.restapi.dao.CitizenDAOImpl;
import gr.ds.restapi.dao.UserDAO;
import gr.ds.restapi.entity.Citizen;
import gr.ds.restapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController<UserType extends User> {

    @Autowired
    private UserDAO<Citizen> citizenDAO;


    @RequestMapping("/citizens")
    public String listCitizens(Model model){

        List<Citizen> citizens = citizenDAO.showALl();

        model.addAttribute("citizens", citizens);

        return "list-citizens";

    }


}
