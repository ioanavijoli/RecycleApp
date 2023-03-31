package com.example.demo.dto;

import com.example.demo.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Category category;
}
