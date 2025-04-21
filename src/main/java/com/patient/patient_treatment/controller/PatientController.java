package com.patient.patient_treatment.controller;

import com.patient.patient_treatment.entity.Patient;
import com.patient.patient_treatment.repository.PatientRepository;
import com.patient.patient_treatment.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    final PatientRepository patientRepository;
    private final PatientService patientService;

    public PatientController(PatientRepository patientRepository, PatientService patientService) {
        this.patientRepository = patientRepository;
        this.patientService = patientService;
    }

    @GetMapping("/patient")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patient/id/{id}") // For example: localhost:8080/patient/1
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id) // Optional <T> (this way of writing this) is supposed to be better, when looking for an error. Here it will either find something or not (empty), instead of being null.
                .map(patient -> ResponseEntity.ok().body(patient)) // If it is found, an 200 HTTP message will be visible in the patient body.
                .orElse(ResponseEntity.notFound().build()); // An 404 HTTP message will be visible, if the ID has not been found.
    }

    @GetMapping("/patient/firstName/{firstName}")
    public List<Patient> getPatientByFirstName(@PathVariable String firstName) {
        return patientService.getPatientByFirstName(firstName);
    }

    @GetMapping("/patient/lastName/{lastName}")
    public List<Patient> getPatientByLastName(@PathVariable String lastName) {
        return patientService.getPatientByLastName(lastName);
    }

}
