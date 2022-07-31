package com.example.parkinglot.model;

import com.example.parkinglot.service.PaymentMethod;
import lombok.Data;

@Data
public class Exit {
    private Integer id;
    private Integer floorId;

    public Exit(Integer id, Integer floorId) {
        this.id = id;
        this.floorId = floorId;
    }

    public boolean processPayment(Ticket ticket, PaymentMethod paymentMethod) {
        Double amountToBePaid = calculateCharges(ticket);
        boolean paymentDone = paymentMethod.processPayment(amountToBePaid);
        if(paymentDone) {
            ticket.setTicketStatus(TicketStatus.PAID);
            return true;
        }
        return false;
    }

    private Double calculateCharges(Ticket ticket) {
        return 1.0;
    }
}
