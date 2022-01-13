package gr.ds.restapi.entity;


import javax.persistence.*;

@Entity
public class Citizen extends User {

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "email")
    private String email;

    public Citizen(){}

    public Citizen(String address, int phoneNumber, String email) {

        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
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


}
