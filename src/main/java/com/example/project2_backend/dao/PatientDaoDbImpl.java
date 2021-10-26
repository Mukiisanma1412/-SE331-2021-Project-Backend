package com.example.project2_backend.dao;

import com.example.project2_backend.entities.patient;
import com.example.project2_backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@Profile("db")
public class PatientDaoDbImpl implements PatientDao {
    @Autowired
    PatientRepository patientRepository;

    @Override
    public Integer getPatientSize() {
        return Math.toIntExact(patientRepository.count());
    }

    @Override
    public Page<patient> getEvents(Integer pageSize, Integer page) {
        return patientRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public patient getEvent(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public patient save(patient event) {
        return patientRepository.save(event);
    }

    @Override
    public Page<patient> getEvent(String title, Pageable page) {
        return patientRepository.findByNameContaining(title,page);
    }
}