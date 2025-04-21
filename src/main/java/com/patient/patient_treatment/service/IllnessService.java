package com.patient.patient_treatment.service;

import com.patient.patient_treatment.entity.Illness;
import com.patient.patient_treatment.repository.IllnessRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IllnessService {

    private final IllnessRepository illnessRepository;

    public IllnessService(IllnessRepository illnessRepository) {
        this.illnessRepository = illnessRepository;
    }

    public List<Illness> getAllIllnesses() {
        return illnessRepository.findAll();
    }

    public Optional<Illness> getIllnessById(Long id) {
        return illnessRepository.findById(id);
    }

    public List<Illness> getIllnessByName(String name) {
        return illnessRepository.getIllnessByNameContainingIgnoreCase(name);
    }
}
