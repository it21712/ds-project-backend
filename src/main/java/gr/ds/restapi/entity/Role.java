package gr.ds.restapi.entity;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = true)
    private int id;

    @Column(nullable = false)
    private String name;




    public Role() { }

    public Role(String name) {
        this.name = name;
    }

    public Role(int id, String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
