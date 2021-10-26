package com.example.project2_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VaccineDTO {

    Long id;
    String name;
    String detail;
    String Country;
    List<VaccinePatientDTO> patientList;
}
