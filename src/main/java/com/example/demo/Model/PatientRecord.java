package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PatientRecord {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;
    private String address;

    public String getName() {
        return name;
    }


    public PatientRecord (Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;

    }
    public PatientRecord() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}