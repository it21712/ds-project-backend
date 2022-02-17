package gr.ds.dsbackendproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homePage(Model model, HttpServletRequest request){

        if(request.isUserInRole("ROLE_ADMIN")){
            return "redirect:/api/root/home";
        }else if(request.isUserInRole("ROLE_USER")){
            return "Welcome user!!";
        }
        else{
            return "not logged in yet.";
        }
    }

}
