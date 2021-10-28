package com.example.project2_backend.dao;

import com.example.project2_backend.security.entity.User;

public interface UserDao {
    User getUser(Long id);
}
