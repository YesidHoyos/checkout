package com.yhoyos.checkout.domain.restclient;

import com.yhoyos.checkout.domain.model.DeliveryDetail;
import com.yhoyos.checkout.domain.model.Order;

public interface LogisticRestClient {

	public DeliveryDetail generateDeliveryDetail(Order order);
}
