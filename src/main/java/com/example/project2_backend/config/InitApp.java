package com.example.project2_backend.config;

import com.example.project2_backend.entities.Vaccine;
import com.example.project2_backend.entities.patient;
import com.example.project2_backend.repository.PatientRepository;
import com.example.project2_backend.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    VaccineRepository vaccineRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent)  {

        patient p1,p2,p3;


        Vaccine v1,v2,v3,v4;
        v1 = vaccineRepository.save(Vaccine.builder().name("Pfizer").Country("German").detail("Pfizer1").build());
        v2 = vaccineRepository.save(Vaccine.builder().name("Moderna").Country("USA").detail("Moderna when").build());
        v3 = vaccineRepository.save(Vaccine.builder().name("JJ").Country("USA").detail("Johnson and Johnson").build());
        v4 = vaccineRepository.save(Vaccine.builder().name("Sinofarm").Country("China").detail("Sinofarm cop.").build());

        p1 = patientRepository.save(patient.builder().name("MK").surname("Sukii").hometown("Thai")
                .img("u").vaccineDate("thu").vaccine(v1).status(1).age(23).build());
        p2 = patientRepository.save(patient.builder().name("MK").surname("Sukii").hometown("Thai")
                .img("u").vaccineDate("thu").vaccine(v1).status(1).age(24).build());
        p3 = patientRepository.save(patient.builder().name("MK").surname("Sukii").hometown("Thai")
                .img("u").vaccineDate("thu").vaccine(v2).status(2).age(25).build());




    }
}
