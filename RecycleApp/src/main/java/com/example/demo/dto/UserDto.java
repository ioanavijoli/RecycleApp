package com.example.demo.dto;

import com.example.demo.model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String cnp;
    private Set<Role> roles = new HashSet<>();
}
