package gr.ds.restapi.entity;

import javax.persistence.*;

//@Entity
public class Pet {

    @Id
    @Column(name = "serial_number")
    private int serialNumber;

    @Column(name = "owner_code",insertable=false, updatable=false)
    private int ownerCode;

    @ManyToOne
    @JoinColumn(name ="owner_code", referencedColumnName = "id")
    private Citizen citizen;


    @Column(name = "type")
    private String type;

    @Column(name = "race")
    private String race;

    @Column(name = "sex")
    private String sex;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "is_approved")
    private int is_approved;

    protected Pet(){}

    public Pet(int serialNumber, int ownerCode, Citizen citizen, String type, String race, String sex, String birthDate, int is_approved) {
        this.serialNumber = serialNumber;
        this.ownerCode = ownerCode;
        this.citizen = citizen;
        this.type = type;
        this.race = race;
        this.sex = sex;
        this.birthDate = birthDate;
        this.is_approved = is_approved;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(int ownerCode) {
        this.ownerCode = ownerCode;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getIs_approved() {
        return is_approved;
    }

    public void setIs_approved(int is_approved) {
        this.is_approved = is_approved;
    }
}
