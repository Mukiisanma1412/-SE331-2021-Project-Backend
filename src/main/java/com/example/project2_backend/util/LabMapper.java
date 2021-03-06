package com.example.project2_backend.util;

import com.example.project2_backend.entities.Vaccine;
import com.example.project2_backend.entities.VaccineDTO;
import com.example.project2_backend.entities.patient;
import com.example.project2_backend.entities.patientDTO;
import com.example.project2_backend.security.entity.User;
import com.example.project2_backend.security.entity.UserAuthDTO;
import com.example.project2_backend.security.entity.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;


import java.util.List;
import java.util.stream.Collectors;

@Mapper(imports = Collectors.class)
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    patientDTO getPatientDTO(patient patient);
    List<patientDTO> getPatientDTO(List<patient> patients);

    VaccineDTO getVaccineDTO(Vaccine Vaccine);
    List<VaccineDTO> getVaccineDTO(List<Vaccine> Vaccine);

    UserDTO getUserDTO(User user);

    //@Mapping(target = "authorities", expression = "java(organizer.getUser().getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))")

    UserDTO getRegisterDto(User user);
    @Mapping(target = "authorities", expression = "java(user.getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))")
    UserAuthDTO getUserAuthDTO(User user);


}
