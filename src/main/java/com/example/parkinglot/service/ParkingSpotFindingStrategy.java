package com.example.parkinglot.service;

import com.example.parkinglot.model.ParkingSpot;
import com.example.parkinglot.model.ParkingSpotType;

import java.util.List;

public interface ParkingSpotFindingStrategy {

    public ParkingSpot findParkingSpot(List<ParkingSpot> parkingSpots);

}
