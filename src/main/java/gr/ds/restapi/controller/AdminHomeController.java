package gr.ds.restapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/root")
public class AdminHomeController {


    @GetMapping("/home")
    public String adminHome(Model model){

        return "admin-home-page";

    }
}
