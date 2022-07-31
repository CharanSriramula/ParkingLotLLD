package com.example.parkinglot.model;

import lombok.Data;

@Data
public class Customer {
    private Integer id;
    private String name;
    private Vehicle vehicle;

    public Customer(Integer id, String name, Vehicle vehicle) {
        this.id = id;
        this.name = name;
        this.vehicle = vehicle;
    }
}
