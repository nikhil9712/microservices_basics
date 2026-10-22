package com.example.paymentService.service;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.example.paymentService.model.PaymentRequest;
import com.example.paymentService.model.PaymentResponse;

@Service
public class PaymentService {

	private static final AtomicInteger requestCounter = new AtomicInteger();

	public PaymentResponse processPayment(PaymentRequest request) {

	    int requestNo = requestCounter.incrementAndGet();

	    System.out.println("Payment Service called: Request " + requestNo);

	    try {
	        Thread.sleep(requestNo % 2 == 0 ? 3000 : 500);
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	        throw new RuntimeException("Payment interrupted", e);
	    }

	    if (requestNo % 2 == 0) {
	        throw new RuntimeException("Simulated payment failure!");
	    }

	    PaymentResponse response = new PaymentResponse();
	    response.setTransactionId(UUID.randomUUID().toString());
	    response.setStatus("SUCCESS");
	    response.setMessage("Payment processed successfully");

	    return response;
	}
}