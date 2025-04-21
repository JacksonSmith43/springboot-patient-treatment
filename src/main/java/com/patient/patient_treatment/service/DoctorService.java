package com.patient.patient_treatment.service;

import com.patient.patient_treatment.entity.Doctor;
import com.patient.patient_treatment.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorsById(Long id) {
        return doctorRepository.findById(id);
    }

    public List<Doctor> getDoctorsByName(String name) {
        return doctorRepository.getDoctorByNameContainingIgnoreCase(name);
    }
}
