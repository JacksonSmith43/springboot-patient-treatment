package com.patient.patient_treatment.controller;

import com.patient.patient_treatment.entity.Hospital;
import com.patient.patient_treatment.entity.Illness;
import com.patient.patient_treatment.repository.IllnessRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IllnessController {

    final IllnessRepository illnessRepository;

    public IllnessController(IllnessRepository illnessRepository) {
        this.illnessRepository = illnessRepository;
    }

    @GetMapping("/illness")
    public List<Illness> getAllIllnesses() {
        return illnessRepository.findAll();
    }

    @GetMapping("/illness/id/{id}")
    public ResponseEntity<Illness> getIllnessById(@PathVariable Long id) {
        return illnessRepository.findById(id)
                .map(illness -> ResponseEntity.ok().body(illness))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/illness/name/{name}")
    public List<Illness> getIllnessByName(@PathVariable String name) {
        return illnessRepository.getIllnessByNameContainingIgnoreCase(name);
    }
}
