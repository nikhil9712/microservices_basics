package com.example.paymentService.model;

import lombok.Data;

@Data
public class PaymentResponse {

	private String transactionId;
    private String status;
    private String message;

}
