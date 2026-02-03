package com.zomato.delivery.dto;

public class DeliveryRequestDTO {
    private Long orderId;
    private String deliveryPerson;
	
    public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getDeliveryPerson() {
		return deliveryPerson;
	}
	public void setDeliveryPerson(String deliveryPerson) {
		this.deliveryPerson = deliveryPerson;
	}
    
    
}
