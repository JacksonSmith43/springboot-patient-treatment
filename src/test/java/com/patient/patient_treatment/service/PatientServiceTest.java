package com.patient.patient_treatment.service;

import com.patient.patient_treatment.entity.Patient;
import com.patient.patient_treatment.repository.PatientRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @MockBean
    private PatientRepository patientRepository;

    @DisplayName("Return all patients.")
    @Test
    void getAllPatients_shouldReturnList() {
        List<Patient> patients = List.of(new Patient("Jane", "Doe", "11.11.1999"));
        Mockito.when(patientRepository.findAll())
                .thenReturn(patients);

        List<Patient> result = patientService.getAllPatients();
        assertThat(result).hasSize(1).extracting(Patient::getFirstName).contains("Jane"); // Exactly one patient is expected in the list. All first names will be extracted, and it checks if "Jane" is among them.    }
    }

    @Test
    @DisplayName("Empty patient list.")
    void getAllPatients_shouldReturnEmptyList() {
        Mockito.when(patientRepository.findAll())
                .thenReturn(List.of());

        List<Patient> result = patientService.getAllPatients();
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("Return patient by ID.")
    void getPatientId_shouldReturnId() {
        Optional<Patient> patientId = Optional.of(new Patient("Jane", "Doe", "11.11.1999")); // Prepare an optional patient to simulate a successful lookup.
        Mockito.when(patientRepository.findById(1L)).thenReturn(patientId);  // Mock the repository to return the patient when ID 1 is requested.

        Optional<Patient> resultId = patientService.getPatientById(1L); // Call the service method with the same ID.
        assertThat(resultId.isPresent()).isTrue();     // Assert that the result is present (patient was found).
    }

    @Test
    @DisplayName("Empty if no ID has been found.")
    void getPatientId_shouldReturnEmptyIdIfNotFound() {
        Mockito.when(patientRepository.findById(1L)).thenReturn(Optional.empty());
        Optional<Patient> result = patientService.getPatientById(1L);
        assertThat(result.isPresent()).isFalse();
        Mockito.verify(patientRepository).findById(1L); // verify is a measure to make sure that this value is being used.

    }

    @Test
    @DisplayName("Return patient by first name.")
    void getPatientByFirstName_shouldReturnFirstName() {
        List<Patient> patient = List.of(new Patient("Jane", "Doe", "11.11.1999"));
        Mockito.when(patientRepository.getPatientByFirstNameContainingIgnoreCase("Jane"))
                .thenReturn(patient);

        List<Patient> result = patientService.getPatientByFirstName("Jane");
        assertThat(result).hasSize(1).extracting(Patient::getFirstName).contains("Jane");
    }

    @Test
    @DisplayName("Should return empty list when first name not found.")
    void getPatientByFirstName_shouldReturnEmptyList() {
        Mockito.when(patientRepository.getPatientByFirstNameContainingIgnoreCase("Jane"))
                .thenReturn(List.of());

        List<Patient> result = patientService.getPatientByFirstName("Jane");
        assertThat(result).isEmpty();
        Mockito.verify(patientRepository).getPatientByFirstNameContainingIgnoreCase("Jane");
    }

    @Test
    @DisplayName("Return patient by last name.")
    void getPatientByLastName_shouldReturnLastName() {
        List<Patient> patient = List.of(new Patient("Jane", "Doe", "11.11.1999"));
        Mockito.when(patientRepository.getPatientByLastNameContainingIgnoreCase("Doe"))
                .thenReturn(patient);

        List<Patient> result = patientService.getPatientByLastName("Doe");
        assertThat(result).hasSize(1).extracting(Patient::getLastName).contains("Doe");
    }

    @Test
    @DisplayName("Should return empty list when last name not found.")
    void getPatientByLastName_shouldReturnEmptyList() {
        Mockito.when(patientRepository.getPatientByLastNameContainingIgnoreCase("Jane")) // When changing this value, the test still does not fail.
                .thenReturn(List.of());

        List<Patient> result = patientService.getPatientByLastName("Jane");
        assertThat(result).isNotNull().isEmpty(); // Checks for null (because that is not empty), in case the value for getPatientByLastNameContainingIgnoreCase("Doe")) is something different to the one being tested for (getPatientByLastName()).
        Mockito.verify(patientRepository).getPatientByLastNameContainingIgnoreCase("Jane");
    }

}
