package com.seatech.Residents.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "residents")
public class ResidentEntity {

    @Id //done for every primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Automically generates ID with an increment of 1
    private long id;

    private int residentId;
    private String residentName;

    @Column(length = 100)
    private String email;

    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getResidentId() {
        return residentId;
    }

    public void setResidentId(int residentId) {
        this.residentId = residentId;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
