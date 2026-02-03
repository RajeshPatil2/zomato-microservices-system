package com.zomato.order.service;

import com.zomato.order.dto.OrderDTO;
import com.zomato.order.dto.OrderResponseDTO;

public interface OrderService {
	OrderResponseDTO placeOrder(OrderDTO dto);

	OrderResponseDTO updateOrderStatus(Long id, String status);
}
