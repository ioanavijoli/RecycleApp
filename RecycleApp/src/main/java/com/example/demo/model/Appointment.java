package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Appointment extends BaseModel {

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "centerId")
    private RecyclingCenter recyclingCenter;
    @ManyToMany
    @JoinColumn(name = "productId")
    private List<Product> productList;
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
}
