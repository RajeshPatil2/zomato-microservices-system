package com.zomato.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zomato.restaurant.entity.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
