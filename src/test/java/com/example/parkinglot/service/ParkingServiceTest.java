package com.example.parkinglot.service;

import com.example.parkinglot.model.*;
import com.example.parkinglot.service.impl.DebitCard;
import com.example.parkinglot.service.impl.FirstFreeSpotIdStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingServiceTest {

    private Integer totalFloors = 5;

    private ParkingLot parkingLot;

    private Map<ParkingSpotType, Integer> parkingSpotTypeLimits = new HashMap<>();

    private ParkingService parkingService;

    @BeforeEach
    public void init() {
        parkingLot = ParkingLot.getInstance(totalFloors);
        for(int floor = 1; floor <= totalFloors; floor++) {
            Entrance entrance = new Entrance(1, floor);
            Exit exit = new Exit(1, floor);
            for(ParkingSpotType parkingSpotType: ParkingSpotType.values()) {
                parkingSpotTypeLimits.put(parkingSpotType, 4);
            }
            parkingLot.createFloor(floor, parkingSpotTypeLimits, entrance, exit, new FirstFreeSpotIdStrategy());
        }
        parkingService = new ParkingService(parkingLot);
    }

    @Test
    public void parkCustomerVehicleTest() {
        Customer customer = getCustomer(1);
        Ticket ticket = parkingService.parkCustomerVehicle(customer);
        Assertions.assertEquals("ACTIVE", ticket.getTicketStatus().toString());
        parkingService.unParkCustomerVehicle(ticket, new DebitCard());
        Assertions.assertEquals("PAID", ticket.getTicketStatus().toString());
    }

    private Customer getCustomer(Integer customerId) {
        Vehicle vehicle = new Vehicle(UUID.randomUUID().toString(), VehicleType.CAR, ParkingSpotType.HIGH);
        return new Customer(customerId, "Charan", vehicle);
    }
}
