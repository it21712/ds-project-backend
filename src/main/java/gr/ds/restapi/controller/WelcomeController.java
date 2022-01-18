package gr.ds.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome(){ return "Welcome!!"; }

    @GetMapping("/welcome/error")
    public String error(){ return "Access Denied!!";}
}
