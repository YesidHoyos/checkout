package com.yhoyos.checkout.domain.repository;

import com.yhoyos.checkout.domain.model.Order;

public interface OrderRepository {

	public long saveOrder(Order order);
}
