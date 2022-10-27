package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "regions")
@Data
@NoArgsConstructor
public class Region {

    @Id
    private Long id;

    private String region;
    private String country;


}
