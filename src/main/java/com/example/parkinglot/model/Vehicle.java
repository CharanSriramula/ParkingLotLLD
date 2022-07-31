package com.example.parkinglot.model;

import lombok.Data;

@Data
public class Vehicle {
    private String id;
    private VehicleType vehicleType;
    private ParkingSpotType parkingSpotType;

    public Vehicle(String id, VehicleType vehicleType, ParkingSpotType parkingSpotType) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.parkingSpotType = parkingSpotType;
    }
}
