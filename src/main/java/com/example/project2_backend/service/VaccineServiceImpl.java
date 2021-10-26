package com.example.project2_backend.service;

import com.example.project2_backend.dao.PatientDao;
import com.example.project2_backend.dao.VaccineDao;
import com.example.project2_backend.entities.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class VaccineServiceImpl implements VaccineService{
    @Autowired
    VaccineDao vaccineDao;

    @Override
    public Integer getVaccineSize() {
        return vaccineDao.getVaccineSize();
    }

    @Override
    public Page<Vaccine> getVaccines(Integer pageSize, Integer page) {
        return vaccineDao.getVaccines(pageSize, page);
    }

    @Override
    public Vaccine getVaccines(Long id) {
        return vaccineDao.getVaccines(id);
    }

    @Override
    public Vaccine save(Vaccine Vaccine) {
        return vaccineDao.save(Vaccine);
    }

    @Override
    public Page<Vaccine> getVaccines(String name, Pageable page) {
        return vaccineDao.getVaccines(name, page);
    }
}
