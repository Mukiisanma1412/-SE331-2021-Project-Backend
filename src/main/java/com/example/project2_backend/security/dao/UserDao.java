package com.example.project2_backend.security.dao;

import com.example.project2_backend.security.entity.User;

public interface UserDao {
    User getUser(Long id);
}
