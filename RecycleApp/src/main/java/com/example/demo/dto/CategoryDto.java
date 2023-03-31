package com.example.demo.dto;

import com.example.demo.model.RecyclingCenter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {

    private Long id;
    private String name;
    private String description;
    private String ImageType;
    private List<RecyclingCenter> recyclingCenterList;
}
