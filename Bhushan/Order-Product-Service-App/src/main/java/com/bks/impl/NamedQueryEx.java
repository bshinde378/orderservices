package com.prati.impl;

	import java.util.List;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;
	import org.hibernate.query.Query;

import com.prati.exmaple.module.Order;
import com.prati.exmaple.module.Product;
	
public class NamedQueryEx {
	
public static void main(String args[]) {
	
	SessionFactory sen=new Configuration().configure().buildSessionFactory();
	Session session=sen.openSession();
	
	Query query=session.createNamedQuery("OrderId",Order.class);
	query.setParameter("OrderId",10);
	List<Product> product=query.getResultList();
	for(Product p:product) {
	System.out.println(p);
	}
	session.close();
	sen.close();
	}
	}



