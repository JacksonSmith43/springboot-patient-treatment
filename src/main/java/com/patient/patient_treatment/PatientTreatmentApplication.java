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
    CommandLineRunner patientCommandLineRunner(PatientRepository patientRepository) {
        return args -> {
            Patient birgit = new Patient("Birgit", "Cadogan", "22.02.2023");
            Patient jackson = new Patient("Jackson", "Smith", "23.02.1998");
            Patient janet = new Patient("Janet", "Jackson", "24.03.1957");
            Patient michael = new Patient("Michael", "Yoshi", "04.09.2023");
            Patient donatello = new Patient("Donatello", "O´Neil", "13.09.1988");
            Patient mickey = new Patient("Miekey", "Patrenko", "14.12.1997");
            Patient raphael = new Patient("Raphael", "Fedori", "02.01.1907");

            patientRepository.saveAll(List.of(birgit, jackson, janet, michael, donatello, mickey, raphael));
        };
    }


    @Bean
    CommandLineRunner doctorCommandLineRunner(DoctorRepository doctorRepository) {
        return args -> {
            Doctor theDoctor = new Doctor("The Doctor", "Weirdo Awareness");
            Doctor hibbert = new Doctor("Hibbert", "Neurology");
            Doctor murphy = new Doctor("Murphy", "Endocrinologist");
            Doctor naylor = new Doctor("Naylor", "Cardiology");
            Doctor levy = new Doctor("Levy", "Pulmonologists");
            Doctor piper = new Doctor("Piper", "Oncology");
            Doctor ngozi = new Doctor("Ngozi", "Psychiatry");

            doctorRepository.saveAll(List.of(theDoctor, hibbert, murphy, naylor, levy, piper, ngozi));
        };
    }

    @Bean
    CommandLineRunner hospitalCommandLineRunner(HospitalRepository hospitalRepository) {
        return args -> {
            Hospital tardisHospital = new Hospital("Tardis Hospital");
            Hospital sanJose = new Hospital("San Jose");
            Hospital holbyCity = new Hospital("Holby City");
            Hospital stJames = new Hospital("St James´s");
            Hospital ninewells = new Hospital("Ninewells");
            Hospital kingsCross = new Hospital("Kings Cross");

            hospitalRepository.saveAll(List.of(tardisHospital, sanJose, holbyCity, stJames, ninewells, kingsCross));
        };
    }

}
