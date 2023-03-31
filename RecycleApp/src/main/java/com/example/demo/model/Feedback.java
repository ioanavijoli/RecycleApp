package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Feedback extends BaseModel {
    private Long userId;
    private String description;
    @ManyToOne()
    @JoinColumn(name = "centerId")
    @JsonIgnore
    private RecyclingCenter recyclingCenter;
}
