package com.example.project2_backend.dao;

import com.example.project2_backend.entities.Vaccine;
import com.example.project2_backend.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class VaccineDaoImpl implements VaccineDao {
    @Autowired
    VaccineRepository VaccineRepository;

    @Override
    public Integer getVaccineSize() {
        return Math.toIntExact(VaccineRepository.count());
    }

    @Override
    public Page<Vaccine> getVaccines(Integer pageSize, Integer page) {
        return VaccineRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Vaccine getVaccines(Long id) {
        return VaccineRepository.getById(id);
    }

    @Override
    public Vaccine save(Vaccine Vaccine) {
        return VaccineRepository.save(Vaccine);
    }

    @Override
    public Page<Vaccine> getVaccines(String name, Pageable page) {
        return VaccineRepository.findByNameContaining(name, page);
    }
}
