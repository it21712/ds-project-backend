package gr.ds.dsbackendproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name = "user_id", insertable = false, updatable = false)
    private int userId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnoreProperties("roles")
    private User user;


    public void removeUser(){
        this.user = null;
    }

    public Role() { }


    public Role(String name) {
        this.name = name;
    }

    public Role(int id, String name){
        this.id=id;
        this.name=name;
    }
    public Role(String name, User user){
        this.id=id;
        this.name=name;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
