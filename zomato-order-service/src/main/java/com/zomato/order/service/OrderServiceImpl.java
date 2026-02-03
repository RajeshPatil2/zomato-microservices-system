package com.zomato.order.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zomato.order.dto.NotificationRequestDTO;
import com.zomato.order.dto.OrderDTO;
import com.zomato.order.dto.OrderItemDTO;
import com.zomato.order.dto.OrderResponseDTO;
import com.zomato.order.dto.PaymentRequestDTO;
import com.zomato.order.dto.PaymentResponseDTO;
import com.zomato.order.entity.Order;
import com.zomato.order.entity.OrderItem;
import com.zomato.order.feign.NotificationClient;
import com.zomato.order.feign.PaymentClient;
import com.zomato.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repository;

	@Autowired
	private PaymentClient paymentClient;

	@Autowired
	private NotificationClient notificationClient;

	@Override
	public OrderResponseDTO placeOrder(OrderDTO dto) {

		// 1️ Create Order
		Order order = new Order();
		order.setUserId(dto.getUserId());
		order.setRestaurantId(dto.getRestaurantId());
		order.setStatus("PLACED");

		// 2️ Items mapping
		List<OrderItem> items = dto.getItems().stream().map(i -> {
			OrderItem item = new OrderItem();
			item.setMenuItemId(i.getMenuItemId());
			item.setQuantity(i.getQuantity());
			item.setPrice(i.getPrice());
			item.setOrder(order);
			return item;
		}).collect(Collectors.toList());

		order.setOrderItems(items);

		// 3️ Total calculation
		double total = items.stream().mapToDouble(i -> i.getPrice() * i.getQuantity()).sum();
		order.setTotalAmount(total);

		// 4️ Save order
		Order savedOrder = repository.save(order);

		// 5️ PAYMENT SERVICE (SAFE)
		try {
			PaymentRequestDTO payReq = new PaymentRequestDTO();
			payReq.setOrderId(savedOrder.getId());
			payReq.setAmount(total);
			payReq.setPaymentMethod("UPI");

			PaymentResponseDTO paymentRes = paymentClient.makePayment(payReq);

			if (paymentRes == null || !"SUCCESS".equalsIgnoreCase(paymentRes.getStatus())) {
				throw new RuntimeException("Payment Failed");
			}
		} catch (Exception e) {
			throw new RuntimeException("Payment Service Error");
		}

		// 6️ NOTIFICATION SERVICE (SAFE)
		try {
			NotificationRequestDTO mail = new NotificationRequestDTO();
			mail.setTo("rajeshpatil2846@gmail.com");
			mail.setSubject("Zomato Order Confirmed");
			mail.setBody("Order #" + savedOrder.getId() + " confirmed. Amount ₹" + total);

			notificationClient.sendEmail(mail);
		} catch (Exception e) {
			System.out.println("Email failed but order confirmed");
		}

		// 7️ Update status
		savedOrder.setStatus("CONFIRMED");
		Order updatedOrder = repository.save(savedOrder);

		// 8️ Response
		return mapToResponse(updatedOrder);
	}

	@Override
	public OrderResponseDTO updateOrderStatus(Long id, String status) {
		Order order = repository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));

		order.setStatus(status);
		return mapToResponse(repository.save(order));
	}

	// ENTITY → DTO
	private OrderResponseDTO mapToResponse(Order order) {

		OrderResponseDTO response = new OrderResponseDTO();
		response.setOrderId(order.getId());
		response.setUserId(order.getUserId());
		response.setRestaurantId(order.getRestaurantId());
		response.setStatus(order.getStatus());
		response.setTotalAmount(order.getTotalAmount());

		response.setItems(order.getOrderItems().stream().map(item -> {
			OrderItemDTO dto = new OrderItemDTO();
			dto.setMenuItemId(item.getMenuItemId());
			dto.setQuantity(item.getQuantity());
			dto.setPrice(item.getPrice());
			return dto;
		}).collect(Collectors.toList()));

		return response;
	}
}
