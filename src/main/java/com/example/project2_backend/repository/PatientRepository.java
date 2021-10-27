package com.example.project2_backend.repository;

import com.example.project2_backend.entities.patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<patient,Long> {
    List<patient> findAll();
    Page<patient> findByName(String title, Pageable pageRequest);
    Page<patient> findByNameContaining(String title, Pageable pageRequest);

}
