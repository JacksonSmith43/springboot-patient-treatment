package com.patient.patient_treatment.repository;

import com.patient.patient_treatment.entity.Doctor;
import com.patient.patient_treatment.entity.Illness;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IllnessRepository extends JpaRepository<Illness, Long> {

    List<Illness> getIllnessByNameContainingIgnoreCase(String name);

}
