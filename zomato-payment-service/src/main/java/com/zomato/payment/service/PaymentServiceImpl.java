package com.zomato.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zomato.payment.dto.PaymentRequestDTO;
import com.zomato.payment.dto.PaymentResponseDTO;
import com.zomato.payment.entity.Payment;
import com.zomato.payment.exception.PaymentNotFoundException;
import com.zomato.payment.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository repository;

	@Override
	public PaymentResponseDTO makePayment(PaymentRequestDTO request) {

		Payment payment = new Payment();
		payment.setOrderId(request.getOrderId());
		payment.setAmount(request.getAmount());
		payment.setPaymentMode(request.getPaymentMode());
		payment.setStatus("SUCCESS"); // real-time gateway success simulation

		Payment saved = repository.save(payment);
		return mapToDTO(saved);
	}

	@Override
	public PaymentResponseDTO getPayment(Long paymentId) {
		Payment payment = repository.findById(paymentId)
				.orElseThrow(() -> new PaymentNotFoundException("Payment not found"));

		return mapToDTO(payment);
	}

	private PaymentResponseDTO mapToDTO(Payment p) {
		PaymentResponseDTO dto = new PaymentResponseDTO();
		dto.setPaymentId(p.getPaymentId());
		dto.setOrderId(p.getOrderId());
		dto.setAmount(p.getAmount());
		dto.setPaymentMode(p.getPaymentMode());
		dto.setStatus(p.getStatus());
		return dto;
	}
}
