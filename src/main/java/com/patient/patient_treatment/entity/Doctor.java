package com.patient.patient_treatment.entity;

import jakarta.persistence.*;
import java.util.List;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Doctor")
public class Doctor {

    @Id
    @SequenceGenerator(name = "doctor_sequence", sequenceName = "doctor_sequence")
    @GeneratedValue(strategy = SEQUENCE, generator = "doctor_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "speciality")
    private String speciality;


    @OneToMany(mappedBy = "doctor")
    private List<Treatment> treatments;

    public Doctor() {

    }
    public Doctor(String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
