package com.prati.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prati.exmaple.module.Order;


public interface OrderRepository extends JpaRepository<Order, Integer> {

}

