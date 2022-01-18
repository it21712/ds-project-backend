package gr.ds.restapi.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Citizen extends User {

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "citizen", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Pet> pets = new ArrayList<>();


    public Citizen(){}

    public Citizen(String address, int phoneNumber, String email) {

        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Citizen(String fullName, String region, String address, int phoneNumber){
        this.setFullName(fullName);
        this.setRegion(region);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Citizen(int id, String username, String passcode, String fullName, String region, int enabled, String address, int phoneNumber, String email ){
        this(address, phoneNumber, email);
        setId(id);
        setUsername(username);
        setPasscode(passcode);
        setFullName(fullName);
        setRegion(region);
        setEnabled(enabled);
    }

    public void addPet(Pet pet){
        pets.add(pet);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pet> getPets(){ return pets; }


}
