package com.example.demo.service.impl;

import com.example.demo.dto.FeedbackDto;
import com.example.demo.dto.RecyclingCenterDto;
import com.example.demo.exception.RecyclingCenterAlreadyAddedException;
import com.example.demo.exception.RecyclingCenterNotFoundException;
import com.example.demo.model.Appointment;
import com.example.demo.model.Category;
import com.example.demo.model.Feedback;
import com.example.demo.model.RecyclingCenter;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.FeedbackRepository;
import com.example.demo.repository.RecyclingCenterRepository;
import com.example.demo.service.RecyclingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecyclingServiceImpl implements RecyclingCenterService {
    @Autowired
    RecyclingCenterRepository recyclingCenterRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    FeedbackRepository feedbackRepository;

    public void addCenter(RecyclingCenter recyclingCenter) throws RecyclingCenterAlreadyAddedException {
        if (recyclingCenterRepository.findByName(recyclingCenter.getName()) != null) {
            throw new RecyclingCenterAlreadyAddedException("This center already exists");
        }
        recyclingCenterRepository.save(recyclingCenter);

    }

    public ArrayList<RecyclingCenter> findRecyclingServiceByName(String name) throws RecyclingCenterNotFoundException {
        ArrayList<RecyclingCenter> recyclingCenterList = recyclingCenterRepository.findAllByNameContains(name);
        if (recyclingCenterList.isEmpty()) {
            throw new RecyclingCenterNotFoundException("No recycling center found");
        }
        return recyclingCenterList;
    }

    public void deleteCenter(Long id) {
        recyclingCenterRepository.deleteById(id);
    }

    public ResponseEntity<?> updateRecyclingCenter(RecyclingCenterDto recyclingCenterDto) throws RecyclingCenterAlreadyAddedException {
        if (recyclingCenterRepository.findByName(recyclingCenterDto.getName()) != null) {
            throw new RecyclingCenterAlreadyAddedException("This center already exists");
        }
        RecyclingCenter recyclingCenter = new RecyclingCenter();
        recyclingCenter.setId(recyclingCenterDto.getId());
        recyclingCenter.setName(recyclingCenterDto.getName());
        recyclingCenter.setDescription(recyclingCenterDto.getDescription());
        recyclingCenter.setCountry(recyclingCenterDto.getCountry());
        recyclingCenter.setCity(recyclingCenterDto.getCity());
        recyclingCenter.setStreet(recyclingCenterDto.getStreet());
        recyclingCenter.setStreetNumber(recyclingCenterDto.getStreetNumber());
        recyclingCenter.setPostalCode(recyclingCenterDto.getPostalCode());
        recyclingCenter.setTelephone(recyclingCenterDto.getTelephone());
        recyclingCenter.setStartWorkTime(recyclingCenterDto.getStartWorkTime());
        recyclingCenter.setEndWorkTime(recyclingCenterDto.getEndWorkTime());
        recyclingCenter.setCategories(recyclingCenterDto.getCategories());
        recyclingCenterRepository.save(recyclingCenter);
        return ResponseEntity.ok(new MessageResponse("Recycling Center updated successfully!"));
    }

    public void getSchedule(RecyclingCenter recyclingCenter) {
        List<Appointment> recyclingCenterAppointments = getAppointmentsByRecyclingCenter(recyclingCenter.getId());
        for (Appointment appointment : recyclingCenterAppointments) {

        }
    }

    public List<Appointment> getAppointmentsByRecyclingCenter(Long id) {

        return appointmentRepository.findAllById(id);
    }

    public ResponseEntity<?> getFeedbacks(Long id) {
        List<Feedback> feedbacks = feedbackRepository.findAllByRecyclingCenterId(id);
        return ResponseEntity.status(HttpStatus.OK).body(feedbacks);

    }

    public void recieveFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = new Feedback();
        feedback.setRecyclingCenter(feedbackDto.getRecyclingCenter());
        feedback.setDescription(feedbackDto.getDescription());
        feedback.setUserId(feedbackDto.getUserId());
        feedbackRepository.save(feedback);
    }

}

