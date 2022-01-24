package com.mahendra.restdemo1.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahendra.restdemo1.entities.Product;

@RestController
@RequestMapping(value="/products",produces = "application/json")
public class ProductResource {
	
	private List<Product> productList = new LinkedList<>();
	
	public ProductResource() {
		productList.add(new Product("Samsung Smart TV ABC123",1000,32000D));
		productList.add(new Product("Panasonic Smart TV PNM123",1001,37000D));
		
	}
	
	/// The final url-endpoint 
	/// http://localhost:9000/products/
	@GetMapping
	public List<Product> getAll(){
		return productList;
	}
	
	/// The final url-endpoint 
	/// http://localhost:9000/products/1000
	@GetMapping(value="/{id}") 
	public Product findProduct(@PathVariable("id") Integer id) {
		System.out.println("Path Varable : "+id);
		for(Product p : productList) {
			if(p.getId().equals(id)) {
				System.out.println("Product : "+p.getName());
				return p;
			}
		}
		return null;
	}
	
}
