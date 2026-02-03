package com.zomato.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zomato.notification.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
