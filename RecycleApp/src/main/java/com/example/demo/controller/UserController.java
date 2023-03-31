package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.management.relation.RoleNotFoundException;
import javax.validation.Valid;

import com.example.demo.exception.*;
import com.example.demo.model.RecyclingCenter;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.payload.request.LogInRequest;
import com.example.demo.payload.request.SignUpRequest;
import com.example.demo.payload.response.JwtResponse;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtils;
import com.example.demo.security.TokenUtils;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.MailServiceImpl;
import com.example.demo.service.impl.RoleServiceImpl;
import com.example.demo.service.impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


//@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    MailServiceImpl mailService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LogInRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) throws RoleNotFoundException, PasswordException {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new UsernameAlreadyUsedException("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new EmailAlreadyUsedException("Error: Email is already in use!"));
        }
        if(!signUpRequest.getPassword().equals(signUpRequest.getConfirmPassword()))
            throw new PasswordException("Passwords didn't match");
        String roles = signUpRequest.getRoles();

        String[] roleNames = roles.split(",");

        Set<Role> roleSet = new HashSet<>();

        for (String name : roleNames) {
            Role role;

            if (name.equals("ADMIN"))
            {
                role = roleService.getAdminRole();
            }
            else
            {
                role = roleService.getUserRole();
            }
            if(role == null)
                throw new RoleNotFoundException();
            roleSet.add(role);
        }

        User user = new User(signUpRequest.getUsername(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getFirstName(),
                signUpRequest.getLastName(),
                signUpRequest.getEmail(),
                signUpRequest.getCnp(),
                roleSet);

        userRepository.save(user);

        mailService.sendEmail(user.getEmail(), "Mesaj", "Hello");

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<?> findUserByName(@PathVariable String name)throws UserNotFoundException {

        ArrayList<User> userList= userService.findUserByName(name);

        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

}