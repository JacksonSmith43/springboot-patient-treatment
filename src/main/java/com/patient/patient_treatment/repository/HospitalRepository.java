package com.patient.patient_treatment.repository;

import com.patient.patient_treatment.entity.Hospital;
import com.patient.patient_treatment.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    List<Hospital> getHospitalByHospitalNameContainingIgnoreCase(String hospitalName);

}
