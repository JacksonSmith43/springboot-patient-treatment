package com.patient.patient_treatment.repository;

import com.patient.patient_treatment.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PatientRepositoryTest {

    @Autowired
    PatientRepository patientRepository;

    @Test
    void testSaveAndFindByFirstName() {
        // Arrange.
        Patient patient = new Patient("Lara", "Croft", "05.05.2005");
        patientRepository.save(patient);

        // Act.
        List<Patient> found = patientRepository.getPatientByFirstNameContainingIgnoreCase("lara");

        // Assert.
        assertEquals(1, found.size());
        assertEquals("Croft", found.get(0).getLastName());
    }
}