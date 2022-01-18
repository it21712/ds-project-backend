package gr.ds.restapi.entity;


import javax.persistence.*;

@Entity
public class MedicalHistory {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "opperation")
    private String operation;

    @Column(name = "pet_number", insertable=false, updatable=false)
    private int petNumber;

    @ManyToOne
    @JoinColumn(name = "pet_number", referencedColumnName = "serial_number")
    private Pet pet;

    protected MedicalHistory(){}

    public MedicalHistory(int id, String operation, Pet pet) {
        this.id = id;
        this.operation = operation;
        this.petNumber = pet.getSerialNumber();
        this.pet = pet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String opperation) {
        this.operation = opperation;
    }

    public int getPetNumber() {
        return petNumber;
    }

    public void setPetNumber(int petNumber) {
        this.petNumber = petNumber;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
