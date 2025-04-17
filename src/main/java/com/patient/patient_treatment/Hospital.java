package com.patient.patient_treatment;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Hospital")
public class Hospital {

    @Id
    @SequenceGenerator(name = "hospital_sequence", sequenceName = "hospital_sequence")
    @GeneratedValue(strategy = SEQUENCE, generator = "hospital_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String hospital_name;


    public Hospital() {

    }

    public Hospital(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }
}
