package gr.ds.dsbackendproject.controller;

import gr.ds.dsbackendproject.dao.EntityDAO;
import gr.ds.dsbackendproject.entity.Citizen;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
@RequestMapping("/api/users/citizens")
public class UserController {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private EntityDAO<Citizen> citizenDAO;



    @RequestMapping("/all")
    public String listCitizens(Model model){

        List<Citizen> citizens = citizenDAO.showALl();

        model.addAttribute("citizens", citizens);

        return "list-citizens";

    }



}
