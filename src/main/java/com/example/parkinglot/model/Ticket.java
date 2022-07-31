package com.example.parkinglot.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Ticket {
    private String id;
    private Customer customer;
    private LocalDateTime issuedAt;
    private ParkingSpot parkingSpot;
    private TicketStatus ticketStatus;

    public Ticket(String id, Customer customer, LocalDateTime issuedAt, ParkingSpot parkingSpot) {
        this.id = id;
        this.customer = customer;
        this.issuedAt = issuedAt;
        this.parkingSpot = parkingSpot;
        this.ticketStatus = TicketStatus.ACTIVE;
    }
}
