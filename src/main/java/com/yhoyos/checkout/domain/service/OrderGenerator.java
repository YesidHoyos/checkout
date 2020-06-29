package com.yhoyos.checkout.domain.service;

import com.yhoyos.checkout.domain.model.Order;

public interface OrderGenerator {

	public Order generateOrder(Order order);
}
