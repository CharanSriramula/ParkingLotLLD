package com.example.parkinglot.service;

import com.example.parkinglot.model.*;

import java.util.List;
import java.util.Map;

public class ParkingService {
    private final ParkingLot parkingLot;

    public ParkingService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket parkCustomerVehicle(Customer customer) {
        ParkingSpotType parkingSpotType = customer.getVehicle().getParkingSpotType();
        Map<Integer, ParkingFloor> parkingFloorMap = parkingLot.getFloors();
        Integer totalFloors = parkingLot.getTotalFloors();
        for(int i = 1; i <= totalFloors; i++) {
            ParkingFloor parkingFloor = parkingFloorMap.get(i);
            List<ParkingSpot> parkingSpots = parkingFloor.getAllSpots().get(parkingSpotType);
            ParkingSpot parkingSpot = parkingFloor.getParkingSpotFindingStrategy().findParkingSpot(parkingSpots);
            if(parkingSpot == null) continue;
            Entrance entrance = parkingFloor.getEntrance();
            Ticket ticket = entrance.issueTicket(customer, parkingSpot);
            parkingSpot.parkVehicle(customer.getVehicle());
            return ticket;
        }
        return null;
    }

    public boolean unParkCustomerVehicle(Ticket ticket, PaymentMethod paymentMethod) {
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        parkingSpot.unParkVehicle();
        Integer floorId = parkingSpot.getFloorId();
        ParkingFloor parkingFloor = parkingLot.getFloors().get(floorId);
        Exit exit = parkingFloor.getExit();
        return exit.processPayment(ticket, paymentMethod);
    }
}
