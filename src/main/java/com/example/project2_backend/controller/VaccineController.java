package com.example.project2_backend.controller;

import com.example.project2_backend.entities.Vaccine;
import com.example.project2_backend.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import com.example.project2_backend.util.LabMapper;

@Controller
public class VaccineController {
    @Autowired
    VaccineService vaccineService;

    @GetMapping("vaccines")
    public ResponseEntity<?> getEventLists(@RequestParam(value = "_limit", required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page, @RequestParam(value = "name", required = false) String name) {
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Vaccine> pageOutput;
        if (name == null) {
            pageOutput = vaccineService.getVaccines(perPage, page);
        } else {
            pageOutput = vaccineService.getVaccines(name, PageRequest.of(page - 1, perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getVaccineDTO(pageOutput.getContent()), responseHeader, HttpStatus.OK);

    }

    @GetMapping("vaccines/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {

        Vaccine output = vaccineService.getVaccines(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getVaccineDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }
}
