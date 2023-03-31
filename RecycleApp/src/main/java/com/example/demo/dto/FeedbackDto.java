package com.example.demo.dto;

import com.example.demo.model.RecyclingCenter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedbackDto {
    private Long userId;
    private String description;
    private RecyclingCenter recyclingCenter;
}
