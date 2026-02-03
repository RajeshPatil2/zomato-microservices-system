package com.zomato.restaurant.service;

import java.util.List;
import com.zomato.restaurant.dto.RestaurantDTO;
import com.zomato.restaurant.entity.Restaurant;

public interface RestaurantService {
	List<RestaurantDTO> getAllRestaurants();

	RestaurantDTO getRestaurantById(Long id);

	Restaurant saveRestaurant(Restaurant restaurant);
}
