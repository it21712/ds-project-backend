package gr.ds.restapi.controller;

import gr.ds.restapi.dao.EntityDAO;
import gr.ds.restapi.entity.Citizen;
import gr.ds.restapi.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/add-citizen", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("citizen_form", "citizen", new Citizen());
    }

    @RequestMapping(value = "/add-citizen-ok", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("citizen")Citizen citizen,
                         BindingResult result, ModelMap model){

        if(result.hasErrors()){
            return "error-form";
        }

        model.addAttribute("id", citizen.getId());
        model.addAttribute("username", citizen.getUsername());
        model.addAttribute("passcode", citizen.getPasscode());
        model.addAttribute("fullName", citizen.getFullName());
        model.addAttribute("region", citizen.getRegion());
        model.addAttribute("address", citizen.getAddress());
        model.addAttribute("phoneNumber", citizen.getPhoneNumber());
        model.addAttribute("email", citizen.getEmail());
        model.addAttribute("enabled", citizen.getEnabled());

        citizen.addRole(new Role("ROLE_USER"));
        citizenDAO.addUser(citizen);

        return "success-form";
    }


}
