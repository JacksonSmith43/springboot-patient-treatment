package com.patient.patient_treatment.repository;

import com.patient.patient_treatment.entity.Doctor;
import com.patient.patient_treatment.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> getDoctorByNameContainingIgnoreCase(String name);
}
