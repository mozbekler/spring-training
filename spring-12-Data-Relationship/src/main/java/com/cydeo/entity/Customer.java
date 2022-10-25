package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customers")
@NoArgsConstructor
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String email;
    private String name;
    private String surName;
    private String userName;

    @OneToMany(mappedBy = "customer")
    private List<Payment> paymentList;

    public Customer(String address, String email, String name, String surName, String userName, List<Payment> paymentList) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.surName = surName;
        this.userName = userName;
        this.paymentList = paymentList;
    }
}
