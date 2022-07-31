package com.example.parkinglot.model;

import com.example.parkinglot.exception.InvalidTotalFloorsException;
import com.example.parkinglot.service.ParkingSpotFindingStrategy;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ParkingLot {
    private String id;
    private Address address;
    private Integer totalFloors;
    private static Integer MAX_FLOORS = 10;
    private Map<Integer, ParkingFloor> floors;

    private static ParkingLot parkingLot;

    private ParkingLot(Integer totalFloors) {
        floors = new HashMap<>();
        this.totalFloors = totalFloors;
    }

    public static ParkingLot getInstance(Integer totalFloors) {
        if(totalFloors < 0 || totalFloors > MAX_FLOORS) {
            throw new InvalidTotalFloorsException();
        }
        if(parkingLot == null) {
            parkingLot = new ParkingLot(totalFloors);
        }
        return parkingLot;
    }

    public void createFloor(Integer id, Map<ParkingSpotType, Integer> parkingSpotTypeLimit, Entrance entrance, Exit exit, ParkingSpotFindingStrategy parkingSpotFindingStrategy) {
        ParkingFloor parkingFloor = new ParkingFloor(id, parkingSpotTypeLimit, entrance, exit, parkingSpotFindingStrategy);
        parkingFloor.createParkingSpots();
        addFloor(parkingFloor);
    }

    public void addFloor(ParkingFloor parkingFloor) {
        this.floors.put(parkingFloor.getId(), parkingFloor);
    }
}
