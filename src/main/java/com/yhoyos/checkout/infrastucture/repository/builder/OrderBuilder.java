package com.yhoyos.checkout.infrastucture.repository.builder;

import java.sql.Timestamp;
import java.util.Set;
import java.util.stream.Collectors;

import com.yhoyos.checkout.domain.model.Order;
import com.yhoyos.checkout.infrastucture.repository.entity.OrderEntity;
import com.yhoyos.checkout.infrastucture.repository.entity.ProductEntity;

public class OrderBuilder {

	public static OrderEntity convertToEntity(Order order) {
		Timestamp dateTimestamp = Timestamp.valueOf(order.getDate());
		Set<ProductEntity> productsEntity = order.getProducts().stream().map(ProductEntity::new).collect(Collectors.toSet());
		return new OrderEntity(order.getClientId(), dateTimestamp, order.getDirection(), productsEntity, order.getBill().getId(), order.getDeliveryDetail().getId());
	}
	
}
