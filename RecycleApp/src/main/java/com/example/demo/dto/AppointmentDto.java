package com.example.demo.dto;

import com.example.demo.model.Product;
import com.example.demo.model.RecyclingCenter;
import com.example.demo.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AppointmentDto {

    private User user;
    private RecyclingCenter recyclingCenter;
    private List<Product> productList;
    private Date orderDate;
}
