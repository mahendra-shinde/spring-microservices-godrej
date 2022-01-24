package com.mahendra.restdemo1.controllers;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahendra.restdemo1.entities.Order;
import com.mahendra.restdemo1.entities.Product;

@RestController
@RequestMapping(value="/orders",produces= {"application/json","application/xml"})
public class OrderResource {

	private List<Order> orderList = new LinkedList<>();
	
	public OrderResource() {
		List<Product> p1 = new LinkedList<>();
		p1.add(new Product("Samsung Smart TV ABC123",1000,32000D));
		p1.add(new Product("Panasonic Smart TV PNM123",1001,37000D));
		
		List<Product> p2 = new LinkedList<>();
		p2.add(new Product("Samsung Galaxy Tab",1003,18000D));
		p2.add(new Product("Dell Inspiron 5xxx",1004,82000D));
		
		orderList.add(new Order(2001,"Mahendra Shinde",new Date(),p1));
		orderList.add(new Order(2002,"Sonali Shinde",new Date(),p2));
	}
}
