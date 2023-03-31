package com.example.demo.repository;

import com.example.demo.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.lang.module.ResolutionException;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {


    List<Appointment> findAllById(Long id);
    List<Appointment> findAllByUserId(Long id);

}
