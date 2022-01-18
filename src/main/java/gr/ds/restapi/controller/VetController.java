package gr.ds.restapi.controller;

import com.google.gson.Gson;
import gr.ds.restapi.dao.UserDAO;
import gr.ds.restapi.entity.CivicOfficial;
import gr.ds.restapi.entity.Vet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vet")
public class VetController {

    @Autowired
    UserDAO<Vet> vetDAO;

    @GetMapping("/home")
    public String info(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = context.getAuthentication();
        String username = auth.getName();

        Vet vet = vetDAO.getUser(username);

        String json = new Gson().toJson(vet);

        return json;
    }
}
