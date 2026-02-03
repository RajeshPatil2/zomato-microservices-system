package com.zomato.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zomato.restaurant.dto.RestaurantDTO;
import com.zomato.restaurant.entity.Restaurant;
import com.zomato.restaurant.service.RestaurantService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

	@Autowired
	private RestaurantService service;

	@PostMapping("/post")
	public Restaurant addRestaurant(@Valid @RequestBody Restaurant restaurant) {
		return service.saveRestaurant(restaurant);
	}

	@GetMapping
	public List<RestaurantDTO> getAllRestaurants() {
		return service.getAllRestaurants();
	}

	@GetMapping("/{id}")
	public RestaurantDTO getRestaurant(@PathVariable Long id) {
		return service.getRestaurantById(id);
	}
}
