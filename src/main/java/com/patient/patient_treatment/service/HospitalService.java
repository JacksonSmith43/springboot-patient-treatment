package com.patient.patient_treatment.service;

import com.patient.patient_treatment.entity.Hospital;
import com.patient.patient_treatment.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    public Optional<Hospital> getHospitalById(Long id) {
        return hospitalRepository.findById(id);
    }

    public List<Hospital> getHospitalByName(String name) {
        return hospitalRepository.getHospitalByHospitalNameContainingIgnoreCase(name);
    }
}
