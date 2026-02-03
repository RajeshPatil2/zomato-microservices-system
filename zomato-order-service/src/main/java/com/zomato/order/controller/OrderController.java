package com.zomato.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zomato.order.dto.OrderDTO;
import com.zomato.order.dto.OrderResponseDTO;
import com.zomato.order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService service;

	/*
	 * @Autowired private OrderProducer producer;
	 */

	@PostMapping("/place")
	public OrderResponseDTO placeOrder(@RequestBody OrderDTO dto) {
		return service.placeOrder(dto);
	}

	/*
	 * @PostMapping("/place") public String placeOrder(@RequestBody OrderEvent
	 * event) {
	 * 
	 * event.setStatus("ORDER_PLACED");
	 * 
	 * producer.sendOrderEvent(event);
	 * 
	 * return "Order placed successfully"; }
	 */

	@PutMapping("/{id}/status")
	public OrderResponseDTO updateStatus(@PathVariable Long id, @RequestParam String status) {
		return service.updateOrderStatus(id, status);
	}
}
