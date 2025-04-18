package com.patient.patient_treatment.controller;

import com.patient.patient_treatment.entity.Hospital;
import com.patient.patient_treatment.repository.HospitalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HospitalController {

    final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }


    @GetMapping("/hospital")
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    @GetMapping("/hospital/id/{id}")
    public ResponseEntity<Hospital> getHospitalById(@PathVariable Long id) {
        return hospitalRepository.findById(id)
                .map(hospital -> ResponseEntity.ok().body(hospital))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/hospital/name/{name}")
    public List<Hospital> getHospitalByName(@PathVariable String name) {
        return hospitalRepository.getHospitalByHospitalNameContainingIgnoreCase(name);
    }

}
