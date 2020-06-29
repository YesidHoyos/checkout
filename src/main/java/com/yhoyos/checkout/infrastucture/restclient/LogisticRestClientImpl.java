package com.yhoyos.checkout.infrastucture.restclient;

import org.springframework.stereotype.Component;

import com.yhoyos.checkout.domain.model.DeliveryDetail;
import com.yhoyos.checkout.domain.model.Order;
import com.yhoyos.checkout.domain.restclient.LogisticRestClient;
import com.yhoyos.checkout.infrastucture.restclient.feign.LogisticClient;

@Component
public class LogisticRestClientImpl implements LogisticRestClient {

	private LogisticClient logisticClient;
	
	public LogisticRestClientImpl(LogisticClient logisticClient) {
		this.logisticClient = logisticClient;
	}
	
	@Override
	public DeliveryDetail generateDeliveryDetail(Order order) {
		return this.logisticClient.generateDelivery(order);
	}

}
