package com.learning.GatewayService.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learning.GatewayService.model.PaymentRequest;
import com.learning.GatewayService.model.PaymentResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class PaymentService {

    private final RestTemplate restTemplate;

    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "paymentService", fallbackMethod = "paymentFallback")
    public PaymentResponse processPayment(PaymentRequest request) {

        return restTemplate.postForObject(
            "http://payment-service/payments/process",
            request,
            PaymentResponse.class
        );
    }

    public PaymentResponse paymentFallback(
            PaymentRequest request, Throwable ex) {

        PaymentResponse response = new PaymentResponse();
        response.setTransactionId("FALLBACK");
        response.setStatus("FAILED");
        response.setMessage("Payment service is temporarily unavailable");

        return response;
    }
}