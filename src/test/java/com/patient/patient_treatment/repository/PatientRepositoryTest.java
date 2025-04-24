package com.patient.patient_treatment.repository;

import com.patient.patient_treatment.entity.Patient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest // This creates a database.
@ActiveProfiles("test")
class PatientRepositoryTest {

    @Autowired
    PatientRepository patientRepository;

    @Test
    @DisplayName("Return patient list.")
    void findPatientList_shouldReturnPatientList() {
        Patient patient = new Patient("David", "Callahan", "05.05.1995");
        patientRepository.save(patient);

        List<Patient> found = patientRepository.findAll();
        assertThat(found).hasSize(1);
    }

    @Test
    @DisplayName("Return empty patient list.")
    void findPatientList_shouldReturnEmptyList() {
        List<Patient> found = patientRepository.findAll();
        assertThat(found).isEmpty();
    }

    @Test
    @DisplayName("Return patient by ID.")
    void findPatientById_shouldReturnPatient() {
        Patient patient = new Patient("David", "Callahan", "05.05.1995");
        Patient savedID = patientRepository.save(patient);
        Long id = savedID.getId();

        Optional<Patient> found = patientRepository.findById(id);
        assertThat(found).isPresent();
        assertThat(found.get().getFirstName()).isEqualTo("David");
    }

    @Test
    @DisplayName("Return empty when ID could not be found.")
    void findPatientById_shouldReturnEmpty() {
        Optional<Patient> found = patientRepository.findById(1L);
        assertThat(found).isEmpty();
    }

    @Test
    @DisplayName("Return patient by first name.")
    void findByFirstName_shouldReturnFirstName() {
        Patient patient = new Patient("David", "Callahan", "05.05.1995");
        patientRepository.save(patient); // Saves the patient in a real test database, that gets created for each test and destroyed after each one.

        List<Patient> found = patientRepository.getPatientByFirstNameContainingIgnoreCase("David"); // Looks for all first names containing "David".
        assertThat(found).isNotEmpty().extracting(Patient::getLastName).contains("Callahan"); // At least one patient in that list has to have the last name "Callahan".
    }

    @Test
    @DisplayName("Return empty list when first name has not been found.")
    void findByFirstName_shouldReturnEmptyList() {
        List<Patient> found = patientRepository.getPatientByFirstNameContainingIgnoreCase("David");
        assertThat(found).isEmpty();
    }


    @Test
    @DisplayName("Return patient by last name.")
    void findByLastName_shouldReturnFirstName() {
        Patient patient = new Patient("David", "Callahan", "05.05.1995");
        patientRepository.save(patient);

        List<Patient> found = patientRepository.getPatientByLastNameContainingIgnoreCase("Callahan");
        assertThat(found).isNotEmpty().extracting(Patient::getFirstName).contains("David");
    }

    @Test
    @DisplayName("Return empty list when last name has not been found.")
    void findByLastName_shouldReturnEmptyList() {
        List<Patient> found = patientRepository.getPatientByLastNameContainingIgnoreCase("Callahan");
        assertThat(found).isEmpty();
    }
}