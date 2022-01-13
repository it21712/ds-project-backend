package gr.ds.restapi.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String homePage(Model model, HttpServletRequest request){

        if(request.isUserInRole("ROLE_ADMIN")){
            return "Welcome admin";
        }else if(request.isUserInRole("ROLE_USER")){
            return "Welcome user!!";
        }
        else{
            return "not logged in yet.";
        }
    }

}
