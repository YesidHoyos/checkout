package com.yhoyos.checkout.infrastucture.restclient.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yhoyos.checkout.domain.model.DeliveryDetail;
import com.yhoyos.checkout.domain.model.Order;

@FeignClient(name = "logistic", url = "http://172.168.0.22:9091/logistic")
public interface LogisticClient {

	@PostMapping()
	public DeliveryDetail generateDelivery(@RequestBody Order order);
}
