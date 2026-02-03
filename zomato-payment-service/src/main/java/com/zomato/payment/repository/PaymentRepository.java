package com.zomato.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zomato.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
