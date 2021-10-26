package com.example.project2_backend.service;

import com.example.project2_backend.entities.patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PatientService {
    Integer getPatientSize();
    Page<patient> getPatients(Integer pageSize, Integer page);
    patient getPatient(Long id);

    patient save(patient event);
    Page<patient> getPatient(String name, Pageable page);
}