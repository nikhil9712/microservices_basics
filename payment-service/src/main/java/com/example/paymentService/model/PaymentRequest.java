package com.example.paymentService.model;

import lombok.Data;

@Data
public class PaymentRequest {
    private String fromAccount;
    private String toAccount;
    private double amount;

}
