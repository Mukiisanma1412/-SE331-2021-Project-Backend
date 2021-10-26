package com.example.project2_backend.repository;

import com.example.project2_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
    User findByUsername(String username);
}