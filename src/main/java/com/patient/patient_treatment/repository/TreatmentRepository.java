package com.patient.patient_treatment.repository;

import com.patient.patient_treatment.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
}
