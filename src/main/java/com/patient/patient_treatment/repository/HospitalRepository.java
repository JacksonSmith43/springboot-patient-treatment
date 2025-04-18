package com.patient.patient_treatment.repository;

import com.patient.patient_treatment.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
