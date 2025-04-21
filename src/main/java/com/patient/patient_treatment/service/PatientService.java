package com.patient.patient_treatment.service;

import com.patient.patient_treatment.entity.Patient;
import com.patient.patient_treatment.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> getPatientByFirstName(String firstName) {
        return patientRepository.getPatientByFirstNameContainingIgnoreCase(firstName);
    }

    public List<Patient> getPatientByLastName(String lastName) {
        return patientRepository.getPatientByLastNameContainingIgnoreCase(lastName);
    }
}