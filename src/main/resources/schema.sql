CREATE TABLE public.doctors
(
    doctor_id      SERIAL PRIMARY KEY,
    name           VARCHAR(30),
    specialisation VARCHAR(40)
);

CREATE TABLE public.hospitals
(
    hospital_id SERIAL PRIMARY KEY,
    name        VARCHAR(50)
);

CREATE TABLE public.illnesses
(
    illness_id SERIAL PRIMARY KEY,
    name       VARCHAR(60)
);

CREATE TABLE public.patients
(
    patient_id SERIAL PRIMARY KEY,
    first_name VARCHAR(30),
    last_name  VARCHAR(30),
    birthdate  DATE
);

CREATE TABLE public.treatments
(
    treatment_id SERIAL PRIMARY KEY,
    patient_id   INTEGER REFERENCES public.patients (patient_id),
    illness_id   INTEGER REFERENCES public.illnesses (illness_id),
    doctor_id    INTEGER REFERENCES public.doctors (doctor_id),
    hospital_id  INTEGER REFERENCES public.hospitals (hospital_id),
    date         DATE
);