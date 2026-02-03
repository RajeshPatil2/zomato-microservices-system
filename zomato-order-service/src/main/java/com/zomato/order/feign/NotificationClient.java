package com.zomato.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.zomato.order.dto.NotificationRequestDTO;

@FeignClient(name = "zomato-notification-service", url = "http://localhost:8087")
public interface NotificationClient {

	@PostMapping("/notifications/email")
	void sendEmail(@RequestBody NotificationRequestDTO request);
}
