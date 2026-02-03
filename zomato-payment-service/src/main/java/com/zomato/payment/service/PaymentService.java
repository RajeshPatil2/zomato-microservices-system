package com.zomato.payment.service;

import com.zomato.payment.dto.*;

public interface PaymentService {

	PaymentResponseDTO makePayment(PaymentRequestDTO request);

	PaymentResponseDTO getPayment(Long paymentId);
}
