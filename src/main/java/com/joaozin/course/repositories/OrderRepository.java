package com.joaozin.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaozin.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
