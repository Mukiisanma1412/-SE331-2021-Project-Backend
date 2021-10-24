package com.example.project2_backend.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    String Surname;
    String hometown;
    int age;
    Date when;

    @ManyToOne
    Vaccine vaccineList;

    int status;
    String img;

}