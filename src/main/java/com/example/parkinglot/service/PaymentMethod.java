package com.example.parkinglot.service;

import com.example.parkinglot.model.Ticket;

public interface PaymentMethod {
    public boolean processPayment(Double amount);
}
