package com.example.demo.service;

import com.example.demo.dto.FeedbackDto;
import com.example.demo.dto.RecyclingCenterDto;
import com.example.demo.exception.RecyclingCenterAlreadyAddedException;
import com.example.demo.exception.RecyclingCenterNotFoundException;
import com.example.demo.model.Feedback;
import com.example.demo.model.RecyclingCenter;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public interface RecyclingCenterService {
    void addCenter(RecyclingCenter recyclingCenter) throws RecyclingCenterAlreadyAddedException;
    void deleteCenter(Long id);
    ArrayList<RecyclingCenter> findRecyclingServiceByName(String name) throws RecyclingCenterNotFoundException;
    ResponseEntity<?> updateRecyclingCenter(RecyclingCenterDto recyclingCenterDto)throws RecyclingCenterAlreadyAddedException;
    ResponseEntity<?> getFeedbacks(Long id);
    void recieveFeedback(FeedbackDto feedbackDto);


}
