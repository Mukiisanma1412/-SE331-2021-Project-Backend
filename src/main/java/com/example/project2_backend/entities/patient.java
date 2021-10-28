package com.example.project2_backend.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    String surname;
    int age;
    String hometown;
    String vaccineDate;
    String img;


    @ManyToOne
    Vaccine vaccine;
    int status;



}