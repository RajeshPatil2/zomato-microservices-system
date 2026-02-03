package com.zomato.delivery.exception;

public class DeliveryNotFoundException extends RuntimeException {
	public DeliveryNotFoundException(String message) {
		super(message);
	}
}
