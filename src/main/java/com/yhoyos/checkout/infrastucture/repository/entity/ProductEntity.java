package com.yhoyos.checkout.infrastucture.repository.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.yhoyos.checkout.domain.model.Product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "product")
@Entity
@Data
@NoArgsConstructor
public class ProductEntity {

	@Id
	@Column(name = "product_id")
	private Long id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "product_cost")
	private double productCost;
	
	@ManyToMany(mappedBy = "products")
    private Set<OrderEntity> orders;
	
	public ProductEntity(Product product) {
		this.id = product.getId();
		this.productCost = product.getCost();
	}
}
