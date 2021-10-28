package com.example.project2_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class patientDTO {
    Long id;
    String name;
    String Surname;
    int age;
    String vaccineDate;
    int status;
    String img;
    PatientVaccineDTO vaccine;
}
