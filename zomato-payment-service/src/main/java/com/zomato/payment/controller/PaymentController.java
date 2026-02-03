package com.zomato.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zomato.payment.dto.PaymentRequestDTO;
import com.zomato.payment.dto.PaymentResponseDTO;
import com.zomato.payment.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentService service;

	// Make Payment
	@PostMapping
	public PaymentResponseDTO pay(@RequestBody PaymentRequestDTO request) {
		return service.makePayment(request);
	}

	// Get Payment Status
	@GetMapping("/{id}")
	public PaymentResponseDTO get(@PathVariable Long id) {
		return service.getPayment(id);
	}
}
