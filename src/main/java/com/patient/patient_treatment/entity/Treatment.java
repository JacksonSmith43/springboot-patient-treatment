package com.patient.patient_treatment.entity;

import jakarta.persistence.*;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Treatment")
public class Treatment {

    @Id
    @SequenceGenerator(name = "treatment_id", sequenceName = "treatment_sequence")
    @GeneratedValue(strategy = SEQUENCE, generator = "treatment_sequence")
    @Column(name = "treatment_id")
    private Long treatmentId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "illness_id")
    private Illness illness;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital; // hospital and not hospital_id because the entire Object gets saved.

    private String date;


    public Treatment() {
    }

    public Treatment(String date, Hospital hospital, Doctor doctor, Illness illness, Patient patient, Long treatmentId) {
        this.date = date;
        this.hospital = hospital;
        this.doctor = doctor;
        this.illness = illness;
        this.patient = patient;
        this.treatmentId = treatmentId;
    }

    public Treatment(String date, Hospital hospital, Doctor doctor, Illness illness, Patient patient) {
        this.date = date;
        this.hospital = hospital;
        this.doctor = doctor;
        this.illness = illness;
        this.patient = patient;
    }


    public Long getTreatmentId() {
        return treatmentId;
    }
    public void setTreatmentId(Long treatment_id) {
        this.treatmentId = treatment_id;
    }

    public Patient getPatient_id() {
        return patient;
    }
    public void setPatient_id(Patient patient) {
        this.patient = patient;
    }

    public Illness getIllness() {
        return illness;
    }
    public void setIllness(Illness illness) {
        this.illness = illness;
    }

    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Hospital getHospital() {
        return hospital;
    }
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
