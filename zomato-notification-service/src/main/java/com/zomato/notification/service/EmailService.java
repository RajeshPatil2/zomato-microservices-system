package com.zomato.notification.service;

import com.zomato.notification.dto.EmailNotificationDTO;

public interface EmailService {
	void sendOrderConfirmation(EmailNotificationDTO dto);
}
