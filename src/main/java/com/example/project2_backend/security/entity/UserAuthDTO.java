package com.example.project2_backend.security.entity;

import java.util.ArrayList;
import java.util.List;

public class UserAuthDTO {
    long id;
    String name;
    List<AuthorityDTO> authorities;
}
