package com.example.project2_backend.controller;


import com.example.project2_backend.security.entity.User;
import com.example.project2_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import util.LabMapper;

@Controller
public class UserController {
    @Autowired
    UserService userService;


}
