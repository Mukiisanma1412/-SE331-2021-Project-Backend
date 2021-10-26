package com.example.project2_backend.controller;

import com.example.project2_backend.entities.patient;
import com.example.project2_backend.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import util.LabMapper;

public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("patients")
    public ResponseEntity<?> getEventLists(@RequestParam(value = "_limit", required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page, @RequestParam(value = "name", required = false) String name) {
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<patient> pageOutput;
        if (name == null) {
            pageOutput = patientService.getPatients(perPage, page);
        } else {
            pageOutput = patientService.getPatient(name, PageRequest.of(page - 1, perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getPatientDao(pageOutput.getContent()), responseHeader, HttpStatus.OK);

    }

    @GetMapping("patients/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {

        patient output = patientService.getPatient(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getPatientDao(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/patients")
    public ResponseEntity<?> addEvent(@RequestBody patient event) {
        patient output = patientService.save(event);
        return ResponseEntity.ok(LabMapper.INSTANCE.getPatientDao(output));


    }
}
