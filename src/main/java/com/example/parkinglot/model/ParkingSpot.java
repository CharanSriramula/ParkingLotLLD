package com.example.parkinglot.model;

import com.example.parkinglot.exception.SlotAlreadyEmptyException;
import com.example.parkinglot.exception.SlotAlreadyOccupiedException;
import lombok.Data;

@Data
public class ParkingSpot {
    private Integer id;
    private Integer floorId;
    private ParkingSpotType parkingSpotType;
    private Vehicle parkedVehicle;

    public ParkingSpot(Integer id, Integer floorId, ParkingSpotType parkingSpotType) {
        this.id = id;
        this.floorId = floorId;
        this.parkingSpotType = parkingSpotType;
        this.parkedVehicle = null;
    }

    public boolean isSlotFree() {
        return this.parkedVehicle == null;
    }

    public void parkVehicle(Vehicle vehicle) {
        if(this.parkedVehicle != null) {
            throw new SlotAlreadyOccupiedException();
        }
        this.parkedVehicle = vehicle;
    }

    public void unParkVehicle() {
        if(this.parkedVehicle == null) {
            throw new SlotAlreadyEmptyException();
        }
        this.parkedVehicle = null;
    }
}
