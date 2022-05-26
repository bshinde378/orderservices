package com.prati.web;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.prati.exmaple.module.Order;
import com.prati.service.OrderSevice;
import com.prati.util.OrderNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")

public class OrderController {
		
		@Autowired
		OrderSevice oService;
		
		@GetMapping("/{oid}")
		public ResponseEntity<Order> getOrderById(@PathVariable Long oid){
			return new ResponseEntity<>(oService.getOrderById(oid), HttpStatus.OK);
		}
		
		@PostMapping
		public ResponseEntity<Order> addOrder(@RequestBody Order order){
			return new ResponseEntity<>(oService.addOrder(order), HttpStatus.CREATED);
		}
		
		@GetMapping
		public ResponseEntity<List<Order>> getAllOrder(){
			return new ResponseEntity<>(oService.fetchAllOrder(), HttpStatus.OK);
		}
			
		@PutMapping("/{oid}")
		public ResponseEntity<Order> updateOrder(@PathVariable Long oid, @RequestBody Order o) throws OrderNotFoundException{
			return new ResponseEntity<>(oService.updateOrder(oid, o), HttpStatus.ACCEPTED);
		}
		
		@PatchMapping("/{oid}")
		public ResponseEntity<Order> updateOrderName(@PathVariable Long oid, @RequestBody String oname){
			return new ResponseEntity<>(oService.updateOrderName(oid, oname), HttpStatus.ACCEPTED);
		}
		
		@DeleteMapping("/{oid}")
		public ResponseEntity<Order> deleteCustomer(@PathVariable Long oid){
			return new ResponseEntity<>(oService.deleteOrder(oid), HttpStatus.ACCEPTED);
		}
		
		
	}
