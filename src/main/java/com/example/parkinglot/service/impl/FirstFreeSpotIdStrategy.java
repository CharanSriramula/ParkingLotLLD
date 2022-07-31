package com.example.parkinglot.service.impl;

import com.example.parkinglot.model.ParkingSpot;
import com.example.parkinglot.model.ParkingSpotType;
import com.example.parkinglot.service.ParkingSpotFindingStrategy;

import java.util.List;

public class FirstFreeSpotIdStrategy implements ParkingSpotFindingStrategy {

    @Override
    public ParkingSpot findParkingSpot(List<ParkingSpot> parkingSpots) {
        for(ParkingSpot parkingSpot: parkingSpots) {
            if(parkingSpot.isSlotFree()) return parkingSpot;
        }
        return null;
    }

}
