package com.zomato.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zomato.delivery.dto.DeliveryRequestDTO;
import com.zomato.delivery.dto.DeliveryResponseDTO;
import com.zomato.delivery.entity.Delivery;
import com.zomato.delivery.exception.DeliveryNotFoundException;
import com.zomato.delivery.repository.DeliveryRepository;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	private DeliveryRepository repository;

	@Override
	public DeliveryResponseDTO createDelivery(DeliveryRequestDTO request) {

		Delivery delivery = new Delivery();
		delivery.setOrderId(request.getOrderId());
		delivery.setDeliveryPerson(request.getDeliveryPerson());
		delivery.setStatus("PLACED");

		Delivery saved = repository.save(delivery);
		return mapToDTO(saved);
	}

	@Override
	public DeliveryResponseDTO updateStatus(Long deliveryId, String status) {

		Delivery delivery = repository.findById(deliveryId)
				.orElseThrow(() -> new DeliveryNotFoundException("Delivery not found"));

		delivery.setStatus(status);
		return mapToDTO(repository.save(delivery));
	}

	@Override
	public DeliveryResponseDTO getDelivery(Long deliveryId) {

		Delivery delivery = repository.findById(deliveryId)
				.orElseThrow(() -> new DeliveryNotFoundException("Delivery not found"));

		return mapToDTO(delivery);
	}

	private DeliveryResponseDTO mapToDTO(Delivery d) {
		DeliveryResponseDTO dto = new DeliveryResponseDTO();
		dto.setDeliveryId(d.getDeliveryId());
		dto.setOrderId(d.getOrderId());
		dto.setDeliveryPerson(d.getDeliveryPerson());
		dto.setStatus(d.getStatus());
		return dto;
	}
}
