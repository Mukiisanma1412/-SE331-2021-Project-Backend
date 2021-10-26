package com.example.project2_backend.config;

import com.example.project2_backend.entities.Vaccine;
import com.example.project2_backend.entities.patient;
import com.example.project2_backend.repository.PatientRepository;
import com.example.project2_backend.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import javax.transaction.Transactional;

public class InitApp implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    VaccineRepository vaccineRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {

        Vaccine v1,v2,v3;
        v1 = vaccineRepository.save(Vaccine.builder().name("Pfizer").Country("German").detail("Pfizer1").build());
        v2 = vaccineRepository.save(Vaccine.builder().name("Moderna").Country("USA").detail("Moderna").build());
        v3 = vaccineRepository.save(Vaccine.builder().name("JJ").Country("USA").detail("Johnson and Johnson").build());

        patient temp;

        temp = patientRepository.save(patient.builder().name("a1").Surname("surname").age(22).hometown("Thailand").status(1).when("12/02/2021").build());
        temp.setVaccine(v1);
        v1.getPatientList().add(temp);

        temp = patientRepository.save(patient.builder().name("a2").Surname("surname2").age(23).hometown("Thailand").status(1).when("15/02/2021").build());
        temp.setVaccine(v2);
        v2.getPatientList().add(temp);
    }
}
