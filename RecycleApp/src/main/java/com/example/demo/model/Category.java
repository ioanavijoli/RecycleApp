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
public class Category extends BaseModel {

    private String name;
    private String description;
    private String ImageType;
    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private List<RecyclingCenter> recyclingCenterList;

}
