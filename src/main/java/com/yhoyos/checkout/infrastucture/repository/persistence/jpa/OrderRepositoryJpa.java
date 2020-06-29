package com.yhoyos.checkout.infrastucture.repository.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yhoyos.checkout.infrastucture.repository.entity.OrderEntity;

public interface OrderRepositoryJpa extends JpaRepository<OrderEntity, Long>{

}
