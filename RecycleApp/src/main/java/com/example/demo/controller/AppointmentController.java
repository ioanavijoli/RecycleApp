package com.example.demo.controller;

import com.example.demo.dto.AppointmentDto;
import com.example.demo.exception.AppointmentNotFoundException;
import com.example.demo.model.Appointment;
import com.example.demo.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PutMapping(value = "/insert")
    public ResponseEntity addAppointment(Appointment appointment){
        appointmentService.addAppointment(appointment);
        return ResponseEntity.status(HttpStatus.OK).body(appointment);
    }
    @GetMapping(value="/getAppointments")
    public ResponseEntity<?> getAppointments(@Valid @RequestBody  Long id) throws AppointmentNotFoundException {

        return appointmentService.getAppointments(id);
    }
}
