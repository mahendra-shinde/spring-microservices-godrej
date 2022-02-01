package com.mahendra.productservice.entities;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "orders")
public class Order implements java.io.Serializable{

	private Integer id;
	private String customer;
	private Date date;
	@XmlElement(name = "product-list")
	private List<Product> productList;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public Order(Integer id, String customer, Date date, List<Product> productList) {
		super();
		this.id = id;
		this.customer = customer;
		this.date = date;
		this.productList = productList;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
