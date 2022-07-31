package com.example.parkinglot.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
public class Entrance {
    private Integer id;
    private Integer floorId;
    private Map<String, Ticket> issuedTickets;

    public Entrance(Integer id, Integer floorId) {
        this.id = id;
        this.floorId = floorId;
        issuedTickets = new HashMap<>();
    }

    public Ticket issueTicket(Customer customer, ParkingSpot parkingSpot) {
        String ticketNumber = UUID.randomUUID().toString();
        Ticket ticket = new Ticket(ticketNumber, customer, LocalDateTime.now(), parkingSpot);
        addTicket(ticket);
        return ticket;
    }

    private void addTicket(Ticket ticket) {
        this.issuedTickets.put(ticket.getId(), ticket);
    }
}
