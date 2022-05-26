package com.prati.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.prati.exmaple.module.Order;


public class GetAndLoadExample {
	
	public static void main(String[] args) {

		System.out.println("Fetch from first level cache Example");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		
		Order order = session.get(Order.class, new Integer(24));
		System.out.println(order);
		
		Order o	 = session.load(Order.class, new Integer(24));
		System.out.println(o);
		
		session.close();
		sessionFactory.close();


	}

}
