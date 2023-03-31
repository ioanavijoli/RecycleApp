package com.example.demo.service;

import com.example.demo.dto.AppointmentDto;
import com.example.demo.exception.AppointmentNotFoundException;
import com.example.demo.model.Appointment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AppointmentService {
    void addAppointment(Appointment appointment);
    ResponseEntity<?> getAppointments(Long id) throws AppointmentNotFoundException;

}
