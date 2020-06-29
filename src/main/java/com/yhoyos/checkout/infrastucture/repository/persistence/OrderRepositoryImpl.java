package com.yhoyos.checkout.infrastucture.repository.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yhoyos.checkout.domain.model.Order;
import com.yhoyos.checkout.domain.repository.OrderRepository;
import com.yhoyos.checkout.infrastucture.repository.builder.OrderBuilder;
import com.yhoyos.checkout.infrastucture.repository.entity.OrderEntity;
import com.yhoyos.checkout.infrastucture.repository.persistence.jpa.OrderRepositoryJpa;

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository{

	private OrderRepositoryJpa orderRepositoryJpa;
	
	public OrderRepositoryImpl(OrderRepositoryJpa orderRepositoryJpa) {
		this.orderRepositoryJpa = orderRepositoryJpa;
	}
	
	@Override
	public long saveOrder(Order order) {
		OrderEntity orderEntity = OrderBuilder.convertToEntity(order);
		return this.orderRepositoryJpa.save(orderEntity).getId();
	}

}
