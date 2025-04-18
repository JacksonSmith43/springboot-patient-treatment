package com.patient.patient_treatment.controller;

import com.patient.patient_treatment.entity.Patient;
import com.patient.patient_treatment.repository.PatientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {

    final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/patient")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/patient/id/{id}") // For example: localhost:8080/patient/1
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id) // Optional <T> (this way of writing this) is supposed to be better, when looking for an error. Here it will either find something or not (empty), instead of being null.
                .map(patient -> ResponseEntity.ok().body(patient)) // If it is found, an 200 HTTP message will be visible in the patient body.
                .orElse(ResponseEntity.notFound().build()); // An 404 HTTP message will be visible, if the ID has not been found.
    }

    @GetMapping("/patient/firstName/{firstName}")
    public List<Patient> getPatientByFirstName(@PathVariable String firstName) {
        return patientRepository.getPatientByFirstNameContainingIgnoreCase(firstName);
    }


}
