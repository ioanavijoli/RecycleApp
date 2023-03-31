package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product extends BaseModel {

    private String name;
    private String description;
    @ManyToOne()
    @JoinColumn(name = "categoryId")
    private Category category;
    @ManyToMany
    @JoinColumn(name="appointmentId")
    private List<Appointment> appointments;

}
