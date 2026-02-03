package com.zomato.restaurant.dto;

import java.util.List;

public class RestaurantDTO {
	private Long id;
	private String name;
	private String city;
	private List<MenuItemDTO> menuItems;

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<MenuItemDTO> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<MenuItemDTO> menuItems) {
		this.menuItems = menuItems;
	}
}
