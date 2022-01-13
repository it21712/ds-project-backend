package gr.ds.restapi.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

    @Id
    @Column(name = "id", updatable = false, nullable = true)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "passcode")
    private String passcode;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "region")
    private String region;

    @Column(name = "enabled")
    private int enabled;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = true)
    )
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
        roles.add(role);
    }

    protected User(){}

    public User(int id, String username, String passcode, String fullName, String region, int enabled) {
        this.id = id;
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

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

}
