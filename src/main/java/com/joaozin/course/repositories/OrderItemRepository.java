package com.joaozin.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaozin.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
