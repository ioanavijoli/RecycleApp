package com.example.demo.service.impl;

import com.example.demo.dto.AppointmentDto;
import com.example.demo.exception.AppointmentNotFoundException;
import com.example.demo.exception.NoProductFoundException;
import com.example.demo.model.Appointment;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public void addAppointment(Appointment appointment) {

        appointmentRepository.save(appointment);
    }

    public ResponseEntity<?> getAppointments(Long id) throws AppointmentNotFoundException {
        List<Appointment> appointments=appointmentRepository.findAllById(id);
        if(appointments.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).
                    body(new AppointmentNotFoundException("Error: No products found!"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(appointments);

    }

}
