package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RecyclingCenter extends BaseModel {

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

    @OneToMany()
    @JoinColumn(name = "centerId")
    private List<Feedback> feedback;

    @ManyToMany()
    @JoinTable(name = "RecyclingCenter_Category", joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "recyclingCenter_id"))
    private List<Category> categories;
}


