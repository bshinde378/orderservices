package com.prati.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prati.exmaple.module.Order;
import com.prati.repository.OrderRepository;
import com.prati.util.OrderNotFoundException;
@Service
public class OrderServiceImpl  implements OrderSevice{
	
	@Autowired
	OrderRepository oRepository;
	
	Map<Long, Order> order = new HashMap<>();

	public Order getOrderById(Long oid) {
		return order.get(oid);
	}
	@Override
	public Order addOrder(Order o) {
	//order.put(o.getOid(), o);
	//return order.get(o.getOid());
	return oRepository.save(o);
		
	}


	@Override
	public Order updateOrder(Long oid, Order o) throws OrderNotFoundException {
		if(null == getOrderById(oid))
		{
			throw new OrderNotFoundException("Customer is not available to our system having id: "+oid);
		}
		order.put(oid, o);
		return order.get(oid);
	}
	
	
	
	@Override
	public Order updateOrderName(Long oid, String name) {
		Order o = order.get(oid);
		o.setOname(name);
		order.put(oid, o);
		return order.get(oid);
	}


	@Override
	public Order deleteOrder(Long oid) {
		return order.remove(oid);
	}

	
	

	@Override
	public List<Order> fetchAllOrder() {
		// TODO Auto-generated method stub
		return oRepository.findAll();
	}
	
	
}



