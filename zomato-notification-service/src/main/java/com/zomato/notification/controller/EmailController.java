package com.zomato.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zomato.notification.dto.EmailNotificationDTO;
import com.zomato.notification.service.EmailService;

@RestController
@RequestMapping("/notifications/email")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@PostMapping("/order-confirm")
	public String sendEmail(@RequestBody EmailNotificationDTO dto) {
		emailService.sendOrderConfirmation(dto);
		return "Order confirmation email sent";
	}
}
