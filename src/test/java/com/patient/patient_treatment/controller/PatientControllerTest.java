package com.patient.patient_treatment.controller;

import com.patient.patient_treatment.entity.Patient;
import com.patient.patient_treatment.repository.PatientRepository;
import com.patient.patient_treatment.service.PatientService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@WebMvcTest(PatientController.class)
class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientService patientService;

    @Test
    @DisplayName("List of Patients.")
    void getAllPatients_shouldReturnList() throws Exception {
        List<Patient> patients = List.of(new Patient("John", "Veigl", "01.01.2000"));
        Mockito.when(patientService.getAllPatients()).thenReturn(patients); // If patientService.getAllPatients() is called, then a list of a patient (John Veigl) should be returned (simulated).
        mockMvc.perform(get("/patient")) // The GET request is only simulated. Does not happen inside of the browser. Happens inside of MockMvc.
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[0].lastName").value("Veigl"));
    }

    @Test
    @DisplayName("Empty patients list.")
    void getAllPatients_shouldReturnEmpty() throws Exception { // throws Exception is not required because an error will occur but because it might. (mockMvc and andExpect) requires it.
        Mockito.when(patientService.getAllPatients())
                .thenReturn(Collections.emptyList()); // Once getAllPatients() has been called, an empty list should be returned.

        mockMvc.perform(get("/patient"))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    @Test
    @DisplayName("Patient ID.")
    void getPatientId_shouldReturnPatientId() throws Exception {
        Patient patientId = new Patient("Kristofer", "Blake", "12.02.2003");
        Mockito.when(patientService.getPatientById(1L)).thenReturn(Optional.of(patientId));

        mockMvc.perform(get("/patient/id/1", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Kristofer"))
                .andExpect(jsonPath("$.lastName").value("Blake"));
    }

    @Test
    @DisplayName("Failed to find ID.")
    void getPatientId_shouldReturnNotFound() throws Exception {
        Long fakeId = 8L;
        Mockito.when(patientService.getPatientById(fakeId))
                .thenReturn(Optional.empty());

        mockMvc.perform(get("/patient/id/{id}", fakeId))
                .andExpect(status().isNotFound()); // An HTTP 404 error will be returned to let the user know that the id could not be found.
    }

    @Test
    @DisplayName("First Name.")
    void getFirstName_shouldReturnFirstName() throws Exception {
        Patient patientFirstName = new Patient("Vincent", "Swoboda", "11.03.2004");
        Mockito.when(patientService.getPatientByFirstName("Vincent"))
                .thenReturn(List.of(patientFirstName));

        mockMvc.perform(get("/patient/firstName/Vincent"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("Vincent"));
    }

    @Test
    @DisplayName("First name empty.")
    void getFirstName_shouldReturnEmptyList() throws Exception {
        Mockito.when(patientService.getPatientByFirstName("Vincent"))
                .thenReturn(Collections.emptyList());

        mockMvc.perform(get("/patient/firstName/Vincent"))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    @Test
    @DisplayName("Last name.")
    void getLastName_shouldReturnLastName() throws Exception {
        Patient patientLastName = new Patient("Jasmine", "Barrowman", "14.02.1996");
        Mockito.when(patientService.getPatientByLastName("Barrowman"))
                .thenReturn(List.of(patientLastName));

        mockMvc.perform(get("/patient/lastName/Barrowman"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].lastName").value("Barrowman"));
    }

    @Test
    @DisplayName("Last name empty.")
    void getLastName_shouldReturnEmptyList() throws Exception {
        Mockito.when(patientService.getPatientByLastName("Barrowman"))
                .thenReturn(Collections.emptyList());

        mockMvc.perform(get("/patient/lastName/Barrowman"))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    // TODO: Might do birthdate one day.

}
