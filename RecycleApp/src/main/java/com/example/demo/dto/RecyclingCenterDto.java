package com.example.demo.dto;

import com.example.demo.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecyclingCenterDto {
    private Long id;
    private String name;
    private String description;
    private String country;
    private String city;
    private String street;
    private String streetNumber;
    private Integer postalCode;
    private String telephone;
    private String startWorkTime;
    private String endWorkTime;
    private List<Category> categories;
}
