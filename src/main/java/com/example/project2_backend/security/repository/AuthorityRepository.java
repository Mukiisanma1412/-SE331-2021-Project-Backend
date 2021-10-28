package com.example.project2_backend.security.repository;


import com.example.project2_backend.security.entity.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project2_backend.security.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(AuthorityName input);
}
