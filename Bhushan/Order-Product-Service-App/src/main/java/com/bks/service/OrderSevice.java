package com.prati.service;

import java.util.List;
import com.prati.exmaple.module.Order;
import com.prati.util.OrderNotFoundException;

public interface OrderSevice {

	
	
	public Order getOrderById(Long Id);
	
	public Order addOrder(Order o);
	
	public Order updateOrder(Long oid, Order o) throws OrderNotFoundException;
	
	public Order updateOrderName(Long oid, String oname);
	
	public Order deleteOrder(Long oid);
	
   public List<Order> fetchAllOrder();
}

