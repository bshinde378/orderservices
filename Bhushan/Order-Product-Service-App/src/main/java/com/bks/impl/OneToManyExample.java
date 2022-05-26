package com.prati.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.prati.exmaple.module.Order;
import com.prati.exmaple.module.Product;

public class OneToManyExample {
	
public static void main(String[] args) {
		
	
	System.out.println("One to Many Fetch Example");
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	
	session.beginTransaction();
	
	Order order = session.get(Order.class, new Long(1));
	
	List<Product> products = order.getProduct();
	for(Product o: products) {
		System.out.println(o);
	}
	
	session.getTransaction().commit();
	session.close();
	sessionFactory.close();
	
	}

}
