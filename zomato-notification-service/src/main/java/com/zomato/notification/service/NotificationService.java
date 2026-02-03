package com.zomato.notification.service;

import com.zomato.notification.dto.*;

public interface NotificationService {

    NotificationResponseDTO sendNotification(NotificationRequestDTO request);

    NotificationResponseDTO getNotification(Long id);
}
