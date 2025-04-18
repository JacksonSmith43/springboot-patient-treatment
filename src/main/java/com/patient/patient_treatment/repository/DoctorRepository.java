package com.patient.patient_treatment.repository;

import com.patient.patient_treatment.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {


}
