package com.yhoyos.checkout.domain.restclient;

import com.yhoyos.checkout.domain.model.Bill;
import com.yhoyos.checkout.domain.model.Order;

public interface BillRestClient {

	public Bill generateBill(Order order);	
}
