package com.zomato.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.zomato.notification.dto.EmailNotificationDTO;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendOrderConfirmation(EmailNotificationDTO dto) {

		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(dto.getToEmail());
			message.setSubject(dto.getSubject());

			StringBuilder body = new StringBuilder();

			body.append("Hello ").append(dto.getCustomerName()).append(",\n\n");
			body.append("Thank you for ordering with Zomato! 🎉\n");
			body.append("Your order has been successfully placed.\n\n");

			body.append("---------------------------------------\n");
			body.append("🧾 Order Details\n");
			body.append("---------------------------------------\n");
			body.append("Order ID      : ").append(dto.getOrderId()).append("\n");
			body.append("Restaurant    : ").append(dto.getRestaurantName()).append("\n");
			body.append("Delivery To   : ").append(dto.getDeliveryAddress()).append("\n\n");

			body.append("---------------------------------------\n");
			body.append("🍽️ Items Ordered\n");
			body.append("---------------------------------------\n");

			double itemTotal = 0;

			if (dto.getItems() != null) {
				int i = 1;
				for (var item : dto.getItems()) {
					body.append(i++).append(". ").append(item.getName()).append(" (Qty: ").append(item.getQuantity())
							.append(")").append(" - ₹").append(item.getPrice()).append("\n");

					itemTotal += item.getPrice() * item.getQuantity();
				}
			}

			body.append("\n---------------------------------------\n");
			body.append("💰 Payment Summary\n");
			body.append("---------------------------------------\n");
			body.append("Item Total    : ₹").append(itemTotal).append("\n");
			body.append("Delivery Fee  : ₹30\n");
			body.append("Total Amount  : ₹").append(itemTotal + 30).append("\n\n");
			body.append("Payment Mode  : ").append(dto.getPaymentMode()).append("\n");
			body.append("Payment Status: SUCCESS\n\n");

			body.append("---------------------------------------\n");
			body.append("🚴 Delivery Information\n");
			body.append("---------------------------------------\n");
			body.append("Estimated Time   : ").append(dto.getEstimatedDeliveryTime()).append("\n\n");

			body.append("You can track your order in the Zomato app.\n\n");
			body.append("Happy Eating! 😋\n");
			body.append("Team Zomato");

			message.setText(body.toString());
			mailSender.send(message);

			System.out.println("Order confirmation email sent successfully.");

		} catch (Exception e) {
			throw new RuntimeException("Failed to send email: " + e.getMessage());
		}
	}
}
