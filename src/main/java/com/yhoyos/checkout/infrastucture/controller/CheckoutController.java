package com.yhoyos.checkout.infrastucture.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yhoyos.checkout.application.handler.GenerateOrderHandler;
import com.yhoyos.checkout.domain.model.Order;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

	private GenerateOrderHandler generateOrderHandler;
	
	public CheckoutController(GenerateOrderHandler generateOrderHandler) {
		this.generateOrderHandler = generateOrderHandler;
	}
	
	@PostMapping
	public Order generateOrder(@RequestBody Order order) {
		return this.generateOrderHandler.generateOrder(order);
	}
}
