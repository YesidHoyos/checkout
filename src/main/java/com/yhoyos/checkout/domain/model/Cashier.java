package com.yhoyos.checkout.domain.model;

import com.yhoyos.checkout.domain.repository.OrderRepository;
import com.yhoyos.checkout.domain.restclient.BillRestClient;
import com.yhoyos.checkout.domain.restclient.LogisticRestClient;
import com.yhoyos.checkout.domain.service.OrderGenerator;

public class Cashier implements OrderGenerator{

	private OrderRepository orderRepository;
	private BillRestClient billRestClient;
	private LogisticRestClient logisticRestClient;
	
	public Cashier(OrderRepository orderRepository, BillRestClient billRestClient, LogisticRestClient logisticRestClient) {
		this.orderRepository = orderRepository;
		this.billRestClient = billRestClient;
		this.logisticRestClient = logisticRestClient;
	}
	@Override
	public Order generateOrder(Order order) {
		Bill bill = billRestClient.generateBill(order);
		DeliveryDetail deliveryDetail = logisticRestClient.generateDeliveryDetail(order);
		
		Order orderGenerated = new Order(order.getClientId(), order.getDate(), order.getDirection(), order.getProducts(), bill, deliveryDetail);		
		long orderId = orderRepository.saveOrder(orderGenerated);
		orderGenerated.setId(orderId);
		return orderGenerated;
	}

}
