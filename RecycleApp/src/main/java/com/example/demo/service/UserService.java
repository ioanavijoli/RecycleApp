package com.example.demo.service;


import com.example.demo.exception.AppointmentNotFoundException;
import com.example.demo.exception.RecyclingCenterNotFoundException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.RecyclingCenter;
import com.example.demo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface UserService {
    // void logIn(String username, String password);

    // void register(UserDto user) throws UsernameAlreadyUsedException, PasswordException, EmailAlreadyUsedException;

    // void update(UserDto user);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    ArrayList<User> findUserByName(String name) throws UserNotFoundException;


}
