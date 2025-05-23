package com.patient.patient_treatment.entity;

import jakarta.persistence.*;

import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Illness")
public class Illness {

    @Id
    @SequenceGenerator(name = "illness_sequence")
    @GeneratedValue(strategy = SEQUENCE, generator = "illness_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "illness")
    private List<Treatment> treatments;

    public Illness(String name) {
        this.name = name;
    }
    public Illness() {
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
}
