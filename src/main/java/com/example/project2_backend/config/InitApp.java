package com.example.project2_backend.config;

import com.example.project2_backend.entities.Vaccine;
import com.example.project2_backend.entities.patient;
import com.example.project2_backend.repository.OrganizeUser;
import com.example.project2_backend.repository.OrganizerRepository;
import com.example.project2_backend.repository.PatientRepository;
import com.example.project2_backend.repository.UserRepository;
import com.example.project2_backend.repository.VaccineRepository;
import jdk.jfr.Event;
import org.apache.catalina.User;
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
    UserRepository userRepository;
    @Autowired
    UserRepository organizerRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

        Vaccine v1,v2,v3;
        v1 = vaccineRepository.save(Vaccine.builder().name("Pfizer").Country("German").detail("Pfizer1").build());
        v2 = vaccineRepository.save(Vaccine.builder().name("Moderna").Country("USA").detail("Moderna").build());
        v3 = vaccineRepository.save(Vaccine.builder().name("JJ").Country("USA").detail("Johnson and Johnson").build());

        patient temp;

        temp = patientRepository.save(patient.builder().name("a1").Surname("surname").age(22).hometown("Thailand").status(1).when("12/02/2021").build());
        temp.setVaccine(v1);
        v1.getPatientList().add(temp);

        temp = patientRepository.save(patient.builder().name("a2").Surname("surname2").age(23).hometown("Thailand").status(1).when("15/02/2021").build());
        temp.setVaccine(v2);
        v2.getPatientList().add(temp);

        temp = patientRepository.save(patient.builder().name("a3").Surname("surname3").age(24).hometown("Thailand").status(1).when("17/02/2021").build());
        temp.setVaccine(v3);
        v3.getPatientList().add(temp);

        Organizer org1,org2,org3;
        org1 = organizerRepository.save(Organizer.builder()
                .name("DOCTOR").build());
        org2 = organizerRepository.save(Organizer.builder()
                .name("Patient").build());
        org3 = organizerRepository.save(Organizer.builder()
                .name("Admin").build());
        Event tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .build());
        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);
        addUser();
        org1.setUser(user1);
        user1.setOrganizer(org1);
        org2.setUser(user2);
        user2.setOrganizer(org2);
        org3.setUser(user3);
        user3.setOrganizer(org3);


    }

    User user1, user2, user3;
    private void addUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Authority authUser = Authority.builder().name(AuthorityName.ROLE_USER).build();
        Authority authAdmin = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
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
                .username("doctor")
                .password(encoder.encode("doctor"))
                .firstname("doctor")
                .lastname("doctor")
                .email("doctor@doctor.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user3 = User.builder()
                .username("patient")
                .password(encoder.encode("patient"))
                .firstname("patient")
                .lastname("patient")
                .email("patient@patient.com")
                .enabled(false)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        authorityRepository.save(authUser);
        authorityRepository.save(authAdmin);
        user1.getAuthorities().add(authUser);
        user1.getAuthorities().add(authAdmin);
        user2.getAuthorities().add(authUser);
        user3.getAuthorities().add(authUser);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

    }

}
