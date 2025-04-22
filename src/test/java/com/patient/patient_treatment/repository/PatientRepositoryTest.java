package com.patient.patient_treatment.repository;

import com.patient.patient_treatment.entity.Patient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class PatientRepositoryTest {

    @Autowired
    PatientRepository patientRepository;

    @Test
    @DisplayName("findByFirstName_shouldReturnPatients")
    void findByFirstName_shouldReturnPatients() {
        Patient patient = new Patient("David", "Callahan", "05.05.1995");
        patientRepository.save(patient);

        List<Patient> found = patientRepository.getPatientByFirstNameContainingIgnoreCase("David");
        assertThat(found).isNotEmpty().extracting(Patient::getLastName).contains("Callahan");
    }
}