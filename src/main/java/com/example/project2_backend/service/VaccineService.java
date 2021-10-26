package com.example.project2_backend.service;

import com.example.project2_backend.entities.Vaccine;
import com.example.project2_backend.entities.patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VaccineService {
    Integer getVaccineSize();
    Page<Vaccine> getVaccines(Integer pageSize, Integer page);
    Vaccine getVaccines(Long id);

    Vaccine save(Vaccine Vaccine);
    Page<Vaccine> getVaccines(String name, Pageable page);
}
