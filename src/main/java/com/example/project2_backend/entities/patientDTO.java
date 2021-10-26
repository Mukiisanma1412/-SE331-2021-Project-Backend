package com.example.project2_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class patientDTO {
    Long id;
    String name;
    String Surname;
    String hometown;
    int age;
    Date when;

    @ManyToOne
    Vaccine vaccine;

    int status;
    String img;
}
