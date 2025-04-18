package com.patient.patient_treatment.controller;

import com.patient.patient_treatment.entity.Treatment;
import com.patient.patient_treatment.repository.TreatmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TreatmentController {

    final TreatmentRepository treatmentRepository;

    TreatmentController(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    @GetMapping("/treatment")
    public List<Treatment> getAllTreatments() {
        return treatmentRepository.findAll();
    }

    @GetMapping("/treatment/id/{id}")
    public ResponseEntity<Treatment> getTreatmentById(@PathVariable Long id) {
        return treatmentRepository.findById(id)
                .map(treatment -> ResponseEntity.ok().body(treatment))
                .orElse(ResponseEntity.notFound().build());
    }
}
