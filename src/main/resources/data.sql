INSERT INTO public.doctors (doctor_id, name, specialisation)
VALUES (1, 'The Doctor', 'Weirdo Awareness'),
       (2, 'Hibbert', 'Neurology'),
       (3, 'Murphy', 'Endocrinologist'),
       (4, 'Naylor', 'Cardiology'),
       (5, 'Levy', 'Pulmonologists'),
       (6, 'Piper', 'Oncology'),
       (7, 'Ngozi', 'Psychiatry');

INSERT INTO public.hospitals (hospital_id, name)
VALUES (1, 'Tardis Hospital'),
       (2, 'San Jose'),
       (3, 'Holby City'),
       (4, 'St James´s'),
       (5, 'Ninewells'),
       (6, 'Kings Cross');

INSERT INTO public.illnesses (illness_id, name)
VALUES (1, 'Autism'),
       (2, 'Fibromyalgie'),
       (3, 'Diabetes'),
       (4, 'Angina'),
       (5, 'Pneumonia'),
       (6, 'Cancer'),
       (7, 'OCD');

INSERT INTO public.patients (patient_id, first_name, last_name, birthdate)
VALUES (36, 'Jackson', 'Smith', '1998-02-23'),
       (37, 'Janet', 'Jackson', '1957-03-24'),
       (38, 'Michael', 'Yoshi', '2023-09-04'),
       (39, 'Donatello', 'O´Neil', '1988-09-13'),
       (40, 'Mikey', 'Patrenko', '1997-12-14'),
       (41, 'Raphael', 'Fedori', '1909-01-02'),
       (42, 'Birgit', 'Cadogan', '2023-02-22');

INSERT INTO public.treatments (treatment_id, patient_id, illness_id, doctor_id, hospital_id, date)
VALUES (1, 36, 1, 1, 1, '2023-06-22'),
       (2, 37, 2, 2, 2, '2001-01-02'),
       (12, 38, 3, 3, 3, '2023-12-25'),
       (20, 39, 4, 4, 4, '1994-04-30'),
       (24, 40, 5, 5, 5, '2005-08-29'),
       (25, 41, 6, 6, 5, '1929-07-10'),
       (27, 42, 7, 7, 6, '2023-06-22');

-- Sequences aktualisieren (optional)

SELECT pg_catalog.setval('public.doctors_doctor_id_seq', 7, true);
SELECT pg_catalog.setval('public.hospitals_hospital_id_seq', 6, true);
SELECT pg_catalog.setval('public.illnesses_illness_id_seq', 7, true);
SELECT pg_catalog.setval('public.patient_patient_id_seq', 42, true);
SELECT pg_catalog.setval('public.treatments_treatment_id_seq', 27, true);