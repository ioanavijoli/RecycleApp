package com.example.demo.repository;

import com.example.demo.model.Appointment;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
    User findByEmail(String email);
    User findUserById(Long id);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    ArrayList<User> findAllByUsernameContains(String username);


}
