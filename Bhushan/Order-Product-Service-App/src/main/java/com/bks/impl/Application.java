package com.prati.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.prati.exmaple.module.Order;
import com.prati.exmaple.module.Product;

public class Application {
	
	public static void main(String[] args) {
		
		System.out.println("One to Many Example");
		List<Product> product = new ArrayList<Product>();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		
		session.beginTransaction();
		Product p1 = new Product(20L,"mobile", "iphone",23, 80000.00);
		session.save(p1);
		product.add(p1);
		
		Order o=new Order(20L, "mobile", "samsung", new Date(2020,9,7) , 6000.00, product);
		session.save(o);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		

	}

}
