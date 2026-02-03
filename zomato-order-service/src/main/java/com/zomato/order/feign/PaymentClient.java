package com.zomato.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.zomato.order.dto.PaymentRequestDTO;
import com.zomato.order.dto.PaymentResponseDTO;

@FeignClient(name = "zomato-payment-service", url = "http://localhost:8086")
public interface PaymentClient {

	@PostMapping("/payments")
	PaymentResponseDTO makePayment(@RequestBody PaymentRequestDTO request);
}
