package com.zomato.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zomato.delivery.entity.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
	Delivery findByOrderId(Long orderId);
}
