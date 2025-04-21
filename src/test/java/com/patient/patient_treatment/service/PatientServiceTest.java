package com.patient.patient_treatment.service;

import com.patient.patient_treatment.entity.Patient;
import com.patient.patient_treatment.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PatientServiceTest {

    PatientRepository patientRepository = Mockito.mock(PatientRepository.class);
    PatientService patientService = new PatientService(patientRepository);

    @Test
    void getAllPatients_shouldReturnList() {
        Patient p1 = new Patient("John", "Doe", "01.01.1970");
        Patient p2 = new Patient("Jane", "Doe", "01.01.1980");
        when(patientRepository.findAll()).thenReturn(Arrays.asList(p1, p2));

        List<Patient> patients = patientService.getAllPatients();

        assertEquals(2, patients.size());
        verify(patientRepository, times(1)).findAll();
    }

    @Test
    void getPatientById_shouldReturnPatient() {
        Patient patient = new Patient("David", "Callahan", "03.03.1990");
        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));

        Optional<Patient> result = patientService.getPatientById(1L);
        assertTrue(result.isPresent());
        assertEquals("David", result.get().getFirstName());
    }


}
