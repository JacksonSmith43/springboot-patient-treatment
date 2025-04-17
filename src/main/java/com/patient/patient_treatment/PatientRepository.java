package com.patient.patient_treatment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> { // <Classname, datatype of id>

}
