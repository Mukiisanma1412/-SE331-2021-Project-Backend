package com.example.project2_backend.repository;

import com.example.project2_backend.entities.Vaccine;
import com.example.project2_backend.entities.patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaccineRepository extends JpaRepository<Vaccine,Long> {
        List<Vaccine> findAll();
        Page<Vaccine> findByName(String title, Pageable pageRequest);
        Page<Vaccine> findByNameContaining(String title, Pageable pageRequest);
}
