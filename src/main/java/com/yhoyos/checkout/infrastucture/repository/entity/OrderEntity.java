package com.yhoyos.checkout.infrastucture.repository.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "purchase_order")
@Entity
@Data
@NoArgsConstructor
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ")
    @SequenceGenerator(sequenceName = "purchase_order_sequence", allocationSize = 1, name = "ORDER_SEQ")
	@Column(name = "purchase_order_id")
	private Long id;
	
	@Column(name = "client_id")
	private long clientId;
	
	@Column(name = "order_date")
	private Timestamp date;
	
	@Column(name = "direction")
	private String direction;	
	
	@ManyToMany
	@JoinTable( name = "product_by_order", joinColumns = @JoinColumn(name = "purchase_order_id"), inverseJoinColumns = @JoinColumn(name = "product_id") )
    private Set<ProductEntity> products;
	
	@Column(name = "bill_id")
	private long billId;
	
	@Column(name = "delivery_detail_id")
	private long deliveryDetailId;

	public OrderEntity(long clientId, Timestamp date, String direction, Set<ProductEntity> products, long billId,
			long deliveryDetailId) {
		this.clientId = clientId;
		this.date = date;
		this.direction = direction;
		this.products = products;
		this.billId = billId;
		this.deliveryDetailId = deliveryDetailId;
	}
}
