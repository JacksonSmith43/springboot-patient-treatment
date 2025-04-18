package com.patient.patient_treatment.repository;

import com.patient.patient_treatment.entity.Illness;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IllnessRepository extends JpaRepository<Illness, Long> {
}
