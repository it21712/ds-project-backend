package gr.ds.restapi.entity;

import javax.persistence.*;


@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Vet  extends User{

    @Column(name = "name")
    private String name;


    protected Vet(){}

    public Vet(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
