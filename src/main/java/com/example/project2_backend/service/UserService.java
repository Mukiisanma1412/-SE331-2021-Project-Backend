package com.example.project2_backend.service;

import com.example.project2_backend.security.entity.User;

public interface UserService {
    User getUser(long id);
}
