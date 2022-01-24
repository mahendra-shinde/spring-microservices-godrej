package com.mahendra.restdemo1.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product implements java.io.Serializable {
	private String name;
	private Integer id;
	private Double price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, Integer id, Double price) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
