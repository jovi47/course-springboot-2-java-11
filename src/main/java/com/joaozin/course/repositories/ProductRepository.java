package com.joaozin.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaozin.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
