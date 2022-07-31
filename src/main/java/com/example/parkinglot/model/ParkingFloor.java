package com.example.parkinglot.model;

import com.example.parkinglot.service.ParkingSpotFindingStrategy;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ParkingFloor {
    private Integer id;
    private Map<ParkingSpotType, Integer> parkingSpotTypeLimit;
    private Map<ParkingSpotType, List<ParkingSpot>> allSpots;
    private Entrance entrance;
    private Exit exit;
    private DisplayBoard displayBoard;
    private ParkingSpotFindingStrategy parkingSpotFindingStrategy;

    public ParkingFloor(Integer id,
                        Map<ParkingSpotType, Integer> parkingSpotTypeLimit,
                        Entrance entrance,
                        Exit exit,
                        ParkingSpotFindingStrategy parkingSpotFindingStrategy) {
        this.id = id;
        this.parkingSpotTypeLimit = parkingSpotTypeLimit;
        this.entrance = entrance;
        this.exit = exit;
        allSpots = new HashMap<>();
        this.parkingSpotFindingStrategy = parkingSpotFindingStrategy;
    }

    public void createParkingSpots() {
        for(ParkingSpotType parkingSpotType: ParkingSpotType.values()) {
            Integer limit = parkingSpotTypeLimit.get(parkingSpotType);
            addParkingSpots(parkingSpotType, limit);
        }
    }

    public void addParkingSpots(ParkingSpotType parkingSpotType, Integer limit) {
        for(int i = 1; i <= limit; i++) {
            ParkingSpot parkingSpot = new ParkingSpot(i, this.id, parkingSpotType);
            if(allSpots.get(parkingSpotType) == null) {
                allSpots.put(parkingSpotType, new ArrayList<>());
            }
            allSpots.get(parkingSpotType).add(parkingSpot);
        }
    }
}
