package gr.ds.restapi.entity;

import javax.persistence.Entity;

@Entity
public class Admin extends User{

    public Admin(){}

    public Admin(int id, String username, String passcode, String fullName, String region, int enabled) {
        setId(id);
        setUsername(username);
        setPasscode(passcode);
        setFullName(fullName);
        setRegion(region);
        setEnabled(enabled);
    }
}
