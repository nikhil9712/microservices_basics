package com.example.paymentService.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.paymentService.model.PaymentRequest;
import com.example.paymentService.model.PaymentResponse;
import com.example.paymentService.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@PostMapping("/process")
	public PaymentResponse processPayment(@RequestBody PaymentRequest request) {

		return paymentService.processPayment(request);
	}
}