package gr.ds.restapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "civic_official")
@PrimaryKeyJoinColumn(name="ID")
public class CivicOfficial extends User{

    protected CivicOfficial(){}


}
