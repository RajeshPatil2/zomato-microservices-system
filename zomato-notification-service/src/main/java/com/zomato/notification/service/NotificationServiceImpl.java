package com.zomato.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zomato.notification.dto.*;
import com.zomato.notification.entity.Notification;
import com.zomato.notification.exception.NotificationNotFoundException;
import com.zomato.notification.repository.NotificationRepository;
import com.zomato.notification.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationRepository repository;

	@Override
	public NotificationResponseDTO sendNotification(NotificationRequestDTO request) {

		// EMAIL / SMS simulation
		System.out.println("Sending " + request.getType() + " to " + request.getReceiver());

		Notification notification = new Notification();
		notification.setOrderId(request.getOrderId());
		notification.setType(request.getType());
		notification.setReceiver(request.getReceiver());
		notification.setMessage(request.getMessage());
		notification.setStatus("SENT");

		Notification saved = repository.save(notification);
		return mapToDTO(saved);
	}

	@Override
	public NotificationResponseDTO getNotification(Long id) {

		Notification notification = repository.findById(id)
				.orElseThrow(() -> new NotificationNotFoundException("Notification not found"));

		return mapToDTO(notification);
	}

	private NotificationResponseDTO mapToDTO(Notification n) {
		NotificationResponseDTO dto = new NotificationResponseDTO();
		dto.setNotificationId(n.getNotificationId());
		dto.setOrderId(n.getOrderId());
		dto.setType(n.getType());
		dto.setReceiver(n.getReceiver());
		dto.setMessage(n.getMessage());
		dto.setStatus(n.getStatus());
		return dto;
	}
}
