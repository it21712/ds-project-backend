package gr.ds.restapi.config;

import gr.ds.restapi.dao.EntityDAO;
import gr.ds.restapi.entity.Admin;
import gr.ds.restapi.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.beans.Transient;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    EntityDAO<Admin> adminDAO;

    public void createAdminIfNotExists(){

        if(adminDAO.getEntity("root0") != null) {
            System.out.println("admin already exists");
            return;
        }
        Admin admin = new Admin(1, "root0", new BCryptPasswordEncoder().encode("root0"),"", "localhost",true);
        admin.addRole(new Role("ROLE_ADMIN", admin));
        adminDAO.addEntity(admin);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        createAdminIfNotExists();
    }
}
