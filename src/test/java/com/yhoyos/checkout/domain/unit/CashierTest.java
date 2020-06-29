package com.yhoyos.checkout.domain.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yhoyos.checkout.domain.model.Bill;
import com.yhoyos.checkout.domain.model.Cashier;
import com.yhoyos.checkout.domain.model.DeliveryDetail;
import com.yhoyos.checkout.domain.model.Order;
import com.yhoyos.checkout.domain.model.Product;
import com.yhoyos.checkout.domain.repository.OrderRepository;
import com.yhoyos.checkout.domain.restclient.BillRestClient;
import com.yhoyos.checkout.domain.restclient.LogisticRestClient;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CashierTest {

	@Mock
	private OrderRepository orderRepository;
	@Mock
	private BillRestClient billRestClient;
	@Mock
	private LogisticRestClient logisticRestClient;
	@InjectMocks
	private Cashier cashier;
	
	private static final String YHOYOS_COMPANY = "Yhoyos's Company";
	private static final long ORDER_ID = 1;
	
	@Test
	public void generateOrderTest() {
		//arrange
		long clientId = 1;
		String direction = "calle9 sur";
		double subTotal = 170000;
		double shippingCost = 10000;
		double totalPrice = 180000;
		long guideNumber = 1234;
		LocalDateTime date = LocalDateTime.now();
		String transportationCompany = YHOYOS_COMPANY;
		
		Set<Product> products = new HashSet<>();
		products.add(new Product(1, 2, 50000));
		products.add(new Product(2, 1, 70000));

		Bill bill = new Bill(1, date, subTotal, shippingCost, totalPrice);
		DeliveryDetail deliveryDetail = new DeliveryDetail(1, "CREATED", direction, guideNumber, transportationCompany);
		
		Order orderExpected = new Order(ORDER_ID, clientId, LocalDateTime.now(), direction, products, bill, deliveryDetail);
		
		Order orderDto = new Order(clientId, date, direction, products, null, null);
		
		when(billRestClient.generateBill(Mockito.any())).thenReturn(bill);
		when(logisticRestClient.generateDeliveryDetail(Mockito.any())).thenReturn(deliveryDetail);
		when(orderRepository.saveOrder(Mockito.any())).thenReturn(ORDER_ID);
		//act
		Order order = this.cashier.generateOrder(orderDto);
		//assert
		assertEquals(orderExpected, order);
	}
}
