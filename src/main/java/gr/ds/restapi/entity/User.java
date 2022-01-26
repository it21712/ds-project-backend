package gr.ds.restapi.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", updatable = false)
    private int id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "passcode")
    private String passcode;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "region")
    private String region;

    @Column(name = "enabled")
    private boolean enabled;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
        roles.add(role);
    }
    public void removeRole(Role role){roles.remove(role);}
    public User(){}

    public User(int id, String username, String passcode, String fullName, String region, boolean enabled) {
        this.id = id;
        this.username = username;
        this.passcode = passcode;
        this.fullName = fullName;
        this.region = region;
        this.enabled = enabled;
    }
    public User(String username, String passcode, String fullName, String region, boolean enabled) {
        this.username = username;
        this.passcode = passcode;
        this.fullName = fullName;
        this.region = region;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

}