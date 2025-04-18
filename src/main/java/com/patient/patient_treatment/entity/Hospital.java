package com.patient.patient_treatment.entity;

import jakarta.persistence.*;

import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Hospital")
public class Hospital {

    @Id
    @SequenceGenerator(name = "hospital_sequence", sequenceName = "hospital_sequence")
    @GeneratedValue(strategy = SEQUENCE, generator = "hospital_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String hospitalName;

    @OneToMany(mappedBy = "hospital")
    private List<Treatment> treatments;

    public Hospital() {

    }
    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
}
