package gr.ds.dsbackendproject.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Admin extends User{

    public Admin(){}

    public Admin(int id, String username, String passcode, String fullName, String region, boolean enabled) {
        setId(id);
        setUsername(username);
        setPasscode(passcode);
        setFullName(fullName);
        setRegion(region);
        setEnabled(enabled);
    }
}
