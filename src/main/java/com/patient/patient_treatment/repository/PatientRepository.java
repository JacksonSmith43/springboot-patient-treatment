package com.patient.patient_treatment.repository;

import com.patient.patient_treatment.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> { // <Classname, datatype of id>

}
