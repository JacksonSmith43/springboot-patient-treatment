package com.patient.patient_treatment;

import com.patient.patient_treatment.entity.*;
import com.patient.patient_treatment.repository.*;
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
    CommandLineRunner treatmentCommandLineRunner(PatientRepository patientRepository,
                                                 DoctorRepository doctorRepository,
                                                 IllnessRepository illnessRepository,
                                                 HospitalRepository hospitalRepository,
                                                 TreatmentRepository treatmentRepository) {
        return args -> {

            Patient patient1 = new Patient("Birgit", "Cadogan", "22.02.2023");
            Patient patient2 = new Patient("Jackson", "Smith", "23.02.1998");
            Patient patient3 = new Patient("Janet", "Jackson", "24.03.1957");
            Patient patient4 = new Patient("Michael", "Yoshi", "04.09.2023");
            Patient patient5 = new Patient("Donatello", "O´Neil", "13.09.1988");
            Patient patient6 = new Patient("Miekey", "Patrenko", "14.12.1997");
            Patient patient7 = new Patient("Raphael", "Fedori", "02.01.1907");

            Doctor doctor1 = new Doctor("The Doctor", "Weirdo Awareness");
            Doctor doctor2 = new Doctor("Hibbert", "Neurology");
            Doctor doctor3 = new Doctor("Murphy", "Endocrinologist");
            Doctor doctor4 = new Doctor("Naylor", "Cardiology");
            Doctor doctor5 = new Doctor("Levy", "Pulmonologists");
            Doctor doctor6 = new Doctor("Piper", "Oncology");
            Doctor doctor7 = new Doctor("Ngozi", "Psychiatry");

            Hospital hospital1 = new Hospital("Tardis Hospital");
            Hospital hospital2 = new Hospital("San Jose");
            Hospital hospital3 = new Hospital("Holby City");
            Hospital hospital4 = new Hospital("St James´s");
            Hospital hospital5 = new Hospital("Ninewells");
            Hospital hospital6 = new Hospital("Kings Cross");

            Illness illness1 = new Illness("Autism");
            Illness illness2 = new Illness("Fibromyalgie");
            Illness illness3 = new Illness("Diabetes");
            Illness illness4 = new Illness("Angina");
            Illness illness5 = new Illness("Pneumonia");
            Illness illness6 = new Illness("Cancer");
            Illness illness7 = new Illness("OCD");

            patientRepository.saveAll(List.of(patient1, patient2, patient3, patient4, patient5, patient6, patient7));
            doctorRepository.saveAll(List.of(doctor1, doctor2, doctor3, doctor4, doctor5, doctor6, doctor7));
            illnessRepository.saveAll(List.of(illness1, illness2, illness3, illness4, illness5, illness6, illness7));
            hospitalRepository.saveAll(List.of(hospital1, hospital2, hospital3, hospital4, hospital5, hospital6));

            Treatment treatment1 = new Treatment("12.01.2023", hospital1, doctor1, illness1, patient1);
            Treatment treatment2 = new Treatment("02.02.2013", hospital1, doctor1, illness1, patient1);
            Treatment treatment3 = new Treatment("03.04.2014", hospital1, doctor1, illness1, patient1);
            Treatment treatment4 = new Treatment("25.12.2024", hospital1, doctor1, illness1, patient1);
            Treatment treatment5 = new Treatment("05.05.2016", hospital1, doctor1, illness1, patient1);
            Treatment treatment6 = new Treatment("06.06.2017", hospital1, doctor1, illness1, patient1);
            Treatment treatment7 = new Treatment("07.07.2019", hospital1, doctor1, illness1, patient1);

            treatmentRepository.saveAll(List.of(treatment1, treatment2, treatment3, treatment4, treatment5, treatment6, treatment7));
        };
    }

}
