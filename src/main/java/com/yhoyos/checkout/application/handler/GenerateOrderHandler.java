package com.yhoyos.checkout.application.handler;

import org.springframework.stereotype.Component;

import com.yhoyos.checkout.domain.model.Order;
import com.yhoyos.checkout.domain.service.OrderGenerator;

@Component
public class GenerateOrderHandler {
	
	private OrderGenerator orderGenerator;

	public GenerateOrderHandler(OrderGenerator orderGenerator) {
		this.orderGenerator = orderGenerator;
	}
	
	public Order generateOrder(Order order) {
		return this.orderGenerator.generateOrder(order);
	}
}
