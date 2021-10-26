package com.example.project2_backend.dao;

import com.example.project2_backend.entities.patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PatientDao {
    Integer getPatientSize();
    Page<patient> getEvents(Integer pageSize, Integer page);
    patient getEvent(Long id);

    patient save(patient event);
    Page<patient> getEvent(String name, Pageable page);
}
