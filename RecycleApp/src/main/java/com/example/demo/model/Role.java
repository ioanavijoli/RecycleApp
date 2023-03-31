package com.example.demo.model;

import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role extends BaseModel{

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleName name;
}
