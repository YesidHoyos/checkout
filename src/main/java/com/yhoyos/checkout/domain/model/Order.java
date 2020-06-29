package com.yhoyos.checkout.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class Order {

	private long id;
	private long clientId;
	private LocalDateTime date;
	private String direction;
	private Set<Product> products;
	private Bill bill;
	private DeliveryDetail deliveryDetail;
	
	
	
	public Order(long id, long clientId, LocalDateTime date, String direction, Set<Product> products, Bill bill,
			DeliveryDetail deliveryDetail) {
		this.id = id;
		this.clientId = clientId;
		this.date = date;
		this.direction = direction;
		this.products = products;
		this.bill = bill;
		this.deliveryDetail = deliveryDetail;
	}
	
	
	
	public Order(long clientId, LocalDateTime date, String direction, Set<Product> products, Bill bill,
			DeliveryDetail deliveryDetail) {
		this.clientId = clientId;
		this.date = date;
		this.direction = direction;
		this.products = products;
		this.bill = bill;
		this.deliveryDetail = deliveryDetail;
	}



	public Order() {};
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public DeliveryDetail getDeliveryDetail() {
		return deliveryDetail;
	}
	public void setDeliveryDetail(DeliveryDetail deliveryDetail) {
		this.deliveryDetail = deliveryDetail;
	}



	@Override
	public int hashCode() {
		return Objects.hash(bill, clientId, date, deliveryDetail, direction, id, products);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(bill, other.bill) && clientId == other.clientId && Objects.equals(date, other.date)
				&& Objects.equals(deliveryDetail, other.deliveryDetail) && Objects.equals(direction, other.direction)
				&& id == other.id && Objects.equals(products, other.products);
	}	
	
}
