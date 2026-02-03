package com.zomato.restaurant.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zomato.restaurant.dto.MenuItemDTO;
import com.zomato.restaurant.dto.RestaurantDTO;
import com.zomato.restaurant.entity.Restaurant;
import com.zomato.restaurant.exception.ResourceNotFoundException;
import com.zomato.restaurant.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    @Override
    public List<RestaurantDTO> getAllRestaurants() {
        return repository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    @Override
    public RestaurantDTO getRestaurantById(Long id) {
        Restaurant restaurant = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + id));
        return convertToDTO(restaurant);
    }

    private RestaurantDTO convertToDTO(Restaurant restaurant) {
        RestaurantDTO dto = new RestaurantDTO();
        dto.setId(restaurant.getId());
        dto.setName(restaurant.getName());
        dto.setCity(restaurant.getCity());

        List<MenuItemDTO> menuDTO = restaurant.getMenuItems().stream().map(item -> {
            MenuItemDTO m = new MenuItemDTO();
            m.setId(item.getId());
            m.setName(item.getName());
            m.setType(item.getType());
            m.setPrice(item.getPrice());
            return m;
        }).collect(Collectors.toList());

        dto.setMenuItems(menuDTO);
        return dto;
    }
}
