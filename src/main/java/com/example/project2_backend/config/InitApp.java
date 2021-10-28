package com.example.project2_backend.config;

import com.example.project2_backend.entities.Vaccine;
import com.example.project2_backend.entities.patient;
import com.example.project2_backend.repository.PatientRepository;
import com.example.project2_backend.repository.VaccineRepository;
import com.example.project2_backend.security.entity.Authority;
import com.example.project2_backend.security.entity.AuthorityName;
import com.example.project2_backend.security.entity.User;
import com.example.project2_backend.security.repository.AuthorityRepository;
import com.example.project2_backend.security.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    VaccineRepository vaccineRepository;
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    UserRepository userRepository;


    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent)  {

        patient p1,p2,p3;


        Vaccine v1,v2,v3,v4;
        v1 = vaccineRepository.save(Vaccine.builder().name("Pfizer").Country("German").detail("Pfizer1").build());
        v2 = vaccineRepository.save(Vaccine.builder().name("Moderna").Country("USA").detail("Moderna when").build());
        v3 = vaccineRepository.save(Vaccine.builder().name("JJ").Country("USA").detail("Johnson and Johnson").build());
        v4 = vaccineRepository.save(Vaccine.builder().name("Sinofarm").Country("China").detail("Sinofarm cop.").build());

        p1 = patientRepository.save(patient.builder().name("MK").surname("Sukii").hometown("Thai")
                .img("u").vaccineDate("thu").vaccine(v1).status(1).age(23).build());
        p2 = patientRepository.save(patient.builder().name("MK").surname("Sukii").hometown("Thai")
                .img("u").vaccineDate("thu").vaccine(v1).status(1).age(24).build());
        p3 = patientRepository.save(patient.builder().name("MK").surname("Sukii").hometown("Thai")
                .img("u").vaccineDate("thu").vaccine(v2).status(2).age(25).build());

        addUser();
    }

    User user1, user2, user3;
    private void addUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Authority authUser = Authority.builder().name(AuthorityName.ROLE_USER).build();
        Authority authAdmin = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        Authority authDoctor = Authority.builder().name(AuthorityName.ROLE_DOCTOR).build();

        user1 = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user2 = User.builder()
                .username("user")
                .password(encoder.encode("user"))
                .firstname("user")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user3 = User.builder()
                .username("Doctor")
                .password(encoder.encode("Doctor"))
                .firstname("Doctor")
                .lastname("Dokkutaa")
                .email("Doctor@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        authorityRepository.save(authUser);
        authorityRepository.save(authAdmin);
        authorityRepository.save(authDoctor);

        user1.getAuthorities().add(authUser);
        user1.getAuthorities().add(authAdmin);
        user2.getAuthorities().add(authUser);
        user3.getAuthorities().add(authDoctor);
        user3.getAuthorities().add(authUser);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

    }
}
