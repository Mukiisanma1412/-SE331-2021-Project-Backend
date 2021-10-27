package com.example.project2_backend.service;

import com.example.project2_backend.dao.PatientDao;
import com.example.project2_backend.entities.patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    PatientDao patientDao;
    @Override
    public Integer getPatientSize() {
        return patientDao.getPatientSize();
    }

    @Override
    public Page<patient> getPatients(Integer pageSize, Integer page) {
        return patientDao.getEvents(pageSize, page);
    }

    @Override
    public patient getPatient(Long id) {
        return patientDao.getEvent(id);
    }

    @Override
    public patient save(patient patient) {
        return patientDao.save(patient);
    }

    @Override
    public Page<patient> getPatient(String name, Pageable page) {
        return patientDao.getEvent(name,page);
    }


}
