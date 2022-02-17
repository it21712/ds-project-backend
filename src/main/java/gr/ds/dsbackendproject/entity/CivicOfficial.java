package gr.ds.dsbackendproject.entity;

import javax.persistence.*;


@Entity
@Table(name = "civic_official")
@PrimaryKeyJoinColumn(name = "id")
public class CivicOfficial extends User{

    @Column(name="code")
    private int code;

    public CivicOfficial(){}



    public CivicOfficial(int id, String username, String passcode, String fullName, String region, boolean enabled) {
        setId(id);
        setUsername(username);
        setPasscode(passcode);
        setFullName(fullName);
        setRegion(region);
        setEnabled(enabled);
    }

    public CivicOfficial(String fullName, String region){
        this.setFullName(fullName);
        this.setRegion(region);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}