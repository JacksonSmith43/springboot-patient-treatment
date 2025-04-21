package com.patient.patient_treatment.repository;

import com.patient.patient_treatment.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> getPatientByFirstNameContainingIgnoreCase(String firstName);
    List<Patient> getPatientByLastNameContainingIgnoreCase(String lastName);
}

