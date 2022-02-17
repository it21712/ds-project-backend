package gr.ds.dsbackendproject.config;

import gr.ds.dsbackendproject.dao.EntityDAO;
import gr.ds.dsbackendproject.entity.Admin;
import gr.ds.dsbackendproject.entity.Role;
import gr.ds.dsbackendproject.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    EntityDAO<Admin> adminDAO;

    @Autowired
    AdminService adminService;

    public void createAdminIfNotExists(){

        /*if(adminDAO.getEntity("root0") != null) {
            System.out.println("admin already exists");
            return;
        }
        Admin admin = new Admin(1, "root0", new BCryptPasswordEncoder().encode("root0"),"", "localhost",true);
        admin.addRole(new Role("ROLE_ADMIN", admin));
        adminDAO.addEntity(admin);*/

        if(adminService.getById(1) != null){
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
