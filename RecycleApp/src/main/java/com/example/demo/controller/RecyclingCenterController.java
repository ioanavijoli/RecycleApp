package com.example.demo.controller;

import com.example.demo.dto.FeedbackDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.RecyclingCenterDto;
import com.example.demo.exception.*;
import com.example.demo.model.Feedback;
import com.example.demo.model.RecyclingCenter;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.payload.request.SignUpRequest;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.repository.RecyclingCenterRepository;
import com.example.demo.security.TokenUtils;
import com.example.demo.service.RecyclingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleNotFoundException;
import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/recyclingCenter")
public class RecyclingCenterController {
    @Autowired
    RecyclingCenterService recyclingCenterService;

    @Autowired
    RecyclingCenterRepository recyclingCenterRepository;

    @GetMapping("/find/{name}")
    public ResponseEntity<?> findRecyclingCenterByName(@PathVariable String name) throws RecyclingCenterNotFoundException {

        ArrayList<RecyclingCenter> recyclingCenterList = recyclingCenterService.findRecyclingServiceByName(name);

        return ResponseEntity.status(HttpStatus.OK).body(recyclingCenterList);
    }

    @PostMapping("/insertCenter")
    public ResponseEntity<?> addCenter(@Valid @RequestBody RecyclingCenterDto recyclingCenterDto) throws RoleNotFoundException, PasswordException, RecyclingCenterAlreadyAddedException {
        if (recyclingCenterRepository.existsByName(recyclingCenterDto.getName())) {
            return ResponseEntity
                    .badRequest()
                    .body(new UsernameAlreadyUsedException("Error: Name is already taken!"));
        }
        RecyclingCenter recyclingCenter= new RecyclingCenter();
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
        recyclingCenterService.addCenter(recyclingCenter);

        return ResponseEntity.ok(new MessageResponse("Recycling Center added successfully!"));
    }

    @PostMapping("/deleteCenter")
    public ResponseEntity deleteCenter(@Valid @RequestBody Long id){

        recyclingCenterService.deleteCenter(id);
        return ResponseEntity.ok(new MessageResponse("Recycling Center removed successfully!"));
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateRecyclingCenter(@Valid @RequestBody RecyclingCenterDto recyclingCenterDto) throws ProductAlreadyAddedException, RecyclingCenterAlreadyAddedException {
     return   recyclingCenterService.updateRecyclingCenter(recyclingCenterDto);
    }
    @GetMapping("/getFeedback")
    public ResponseEntity<?> getFeedback(@Valid @RequestBody Long id)  {

        return recyclingCenterService.getFeedbacks(id);
    }
    @PostMapping("/recieveFeedback")
    public ResponseEntity<?> recieveFeedback(@Valid @RequestBody FeedbackDto feedbackDto){
        recyclingCenterService.recieveFeedback(feedbackDto);
        return ResponseEntity.ok(new MessageResponse("Thanks for your feedback!"));
    }
}
