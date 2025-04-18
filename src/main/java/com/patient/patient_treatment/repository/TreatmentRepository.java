package com.patient.patient_treatment.repository;

import com.patient.patient_treatment.entity.Doctor;
import com.patient.patient_treatment.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {

}
