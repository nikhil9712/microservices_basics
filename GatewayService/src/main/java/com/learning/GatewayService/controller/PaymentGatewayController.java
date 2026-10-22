package com.learning.GatewayService.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.GatewayService.model.PaymentRequest;
import com.learning.GatewayService.model.PaymentResponse;
import com.learning.GatewayService.service.PaymentService;

@RestController
@RequestMapping("/gateway/payments")
public class PaymentGatewayController {

    private final PaymentService paymentService;

    public PaymentGatewayController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    public PaymentResponse processPayment(
            @RequestBody PaymentRequest request) {
        System.out.println(">>> Gateway Controller Reached");
        return paymentService.processPayment(request);
    }
}