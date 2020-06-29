package com.yhoyos.checkout.infrastucture.restclient.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.yhoyos.checkout.domain.model.Bill;
import com.yhoyos.checkout.domain.model.Order;

@FeignClient(name = "bill", url = "http://172.168.0.21:9090/bill")
public interface BillClient {

	@PostMapping()
	public Bill generateBill(@RequestBody Order order);
}
