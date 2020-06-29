package com.yhoyos.checkout.infrastucture.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yhoyos.checkout.domain.model.Cashier;
import com.yhoyos.checkout.infrastucture.repository.persistence.OrderRepositoryImpl;
import com.yhoyos.checkout.infrastucture.restclient.BillRestClientImpl;
import com.yhoyos.checkout.infrastucture.restclient.LogisticRestClientImpl;

@Configuration
public class BeanFactory {

	@Autowired
	private OrderRepositoryImpl orderRepositoryImpl;
	@Autowired
	private BillRestClientImpl billRestClientImpl;
	@Autowired
	private LogisticRestClientImpl logisticRestClientImpl;
	
	@Bean
	public Cashier cashier() {
		return new Cashier(orderRepositoryImpl, billRestClientImpl, logisticRestClientImpl);
	}
}
