package com.zomato.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zomato.notification.dto.*;
import com.zomato.notification.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

	@Autowired
	private NotificationService service;

	// Send Email / SMS
	@PostMapping
	public NotificationResponseDTO send(@RequestBody NotificationRequestDTO request) {
		return service.sendNotification(request);
	}

	// Get notification details
	@GetMapping("/{id}")
	public NotificationResponseDTO get(@PathVariable Long id) {
		return service.getNotification(id);
	}
}
