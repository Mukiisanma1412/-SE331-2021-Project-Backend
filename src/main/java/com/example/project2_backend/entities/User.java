package com.example.project2_backend.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User<Authority, Organizer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private Long id;

    @Column(name = "USERNAME", length = 50, unique = true)
    @NotNull
    private String username;

    @Column(name = "PASSWORD", length = 100)
    @NotNull
    private String password;

    @Column(name = "FIRSTNAME", length = 50)
    @NotNull
    private String firstname;

    @Column(name = "LASTNAME", length = 50)
    @NotNull
    private String lastname;

    @Column(name = "EMAIL", length = 50)
    @NotNull
    private String email;

    @Column(name = "ENABLED")
    @NotNull
    private Boolean enabled;

    @Column(name = "LASTPASSWORDRESETDATE")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date lastPasswordResetDate;

    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Authority> authorities = new ArrayList<>();
    @OneToOne
    Organizer organizer;
    public Object getOrganizer() {
        return null;
    }

}


