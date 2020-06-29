package com.yhoyos.checkout.infrastucture.restclient;

import org.springframework.stereotype.Component;

import com.yhoyos.checkout.domain.model.Bill;
import com.yhoyos.checkout.domain.model.Order;
import com.yhoyos.checkout.domain.restclient.BillRestClient;
import com.yhoyos.checkout.infrastucture.restclient.feign.BillClient;

@Component
public class BillRestClientImpl implements BillRestClient {
	
	private BillClient billClient;
	
	public BillRestClientImpl(BillClient billClient) {
		this.billClient = billClient;
	}

	@Override
	public Bill generateBill(Order order) {
		return this.billClient.generateBill(order);
	}

}
