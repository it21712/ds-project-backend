package gr.ds.restapi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Citizen extends User {

    @Column(name = "code")
    private int code;

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

    public Citizen(int id, int code, String username, String passCode, String fullName, String region, String address, int phoneNumber, String email, boolean enabled){
        this.code = code;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.setId(id);
        this.setRegion(region);
        this.setFullName(fullName);
        this.setUsername(username);
        this.setPasscode(passCode);
        this.setEnabled(enabled);
    }

    public Citizen(String fullName, String region, String address, int phoneNumber){
        this.setFullName(fullName);
        this.setRegion(region);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Citizen(int code, String fullName, String region, String address, int phoneNumber){
        this.code = code;
        this.setFullName(fullName);
        this.setRegion(region);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


    public void addPet(Pet pet){
        pets.add(pet);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
