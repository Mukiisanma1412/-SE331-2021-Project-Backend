package com.example.project2_backend.controller;


import com.example.project2_backend.security.entity.User;
import com.example.project2_backend.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import util.LabMapper;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("user/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {

        User output = userService.getUser(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getUserDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

}
