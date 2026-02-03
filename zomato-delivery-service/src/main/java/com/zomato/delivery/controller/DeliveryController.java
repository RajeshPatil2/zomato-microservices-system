package com.zomato.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zomato.delivery.dto.DeliveryRequestDTO;
import com.zomato.delivery.dto.DeliveryResponseDTO;
import com.zomato.delivery.service.DeliveryService;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

	@Autowired
	private DeliveryService service;

	// Create delivery
	@PostMapping
	public DeliveryResponseDTO create(@RequestBody DeliveryRequestDTO request) {
		return service.createDelivery(request);
	}

	// Update delivery status
	@PutMapping("/{id}/status")
	public DeliveryResponseDTO updateStatus(@PathVariable Long id, @RequestParam String status) {
		return service.updateStatus(id, status);
	}

	// Get delivery details
	@GetMapping("/{id}")
	public DeliveryResponseDTO get(@PathVariable Long id) {
		return service.getDelivery(id);
	}
}
