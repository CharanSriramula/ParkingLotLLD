package com.example.parkinglot.service.impl;

import com.example.parkinglot.service.PaymentMethod;

public class CreditCard implements PaymentMethod {
    @Override
    public boolean processPayment(Double amount) {
        return true;
    }
}
