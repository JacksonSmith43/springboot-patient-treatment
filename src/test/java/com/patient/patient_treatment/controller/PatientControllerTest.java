package com.patient.patient_treatment.controller;

import com.patient.patient_treatment.entity.Patient;
import com.patient.patient_treatment.service.PatientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PatientControllerTest {

    PatientService patientService = Mockito.mock(PatientService.class);
    PatientController controller = new PatientController(patientService);

    @Test
    void getPatientById_shouldReturnPatientInResponseEntity() {
        Patient patient = new Patient("Denise", "Bowker", "04.04.2004");
        when(patientService.getPatientById(1L)).thenReturn(Optional.of(patient));

        ResponseEntity<Patient> response = controller.getPatientById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Denise", response.getBody().getFirstName());
    }

    @Test
    void getPatientById_shouldReturnNotFound() {
        when(patientService.getPatientById(99L)).thenReturn(Optional.empty());

        ResponseEntity<Patient> response = controller.getPatientById(99L);
        assertEquals(404, response.getStatusCodeValue());
    }
}
