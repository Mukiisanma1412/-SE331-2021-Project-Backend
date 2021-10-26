package com.example.project2_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientVaccineDTO {
    Long id;
    String name;
    List<patientGetVaccine> patientGetVaccineList = new ArrayList<>();
}
