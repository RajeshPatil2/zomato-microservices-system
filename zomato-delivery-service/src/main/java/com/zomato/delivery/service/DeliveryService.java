package com.zomato.delivery.service;

import com.zomato.delivery.dto.DeliveryRequestDTO;
import com.zomato.delivery.dto.DeliveryResponseDTO;

public interface DeliveryService {

	DeliveryResponseDTO createDelivery(DeliveryRequestDTO request);

    DeliveryResponseDTO updateStatus(Long deliveryId, String status);

    DeliveryResponseDTO getDelivery(Long deliveryId);
}
