package com.zomato.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.zomato.order.feign")
public class ZomatoOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZomatoOrderServiceApplication.class, args);
	}
}
