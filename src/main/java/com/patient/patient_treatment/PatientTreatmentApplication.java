package com.patient.patient_treatment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class PatientTreatmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientTreatmentApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            Patient birgit = new Patient("Birgit", "Cadogan", "22.02.2023");
            Patient jackson = new Patient("Jackson", "Smith", "23.02.1998");

            patientRepository.saveAll(List.of(birgit, jackson));
        };
    }

}
