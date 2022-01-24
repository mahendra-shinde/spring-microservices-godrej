package com.mahendra.restdemo1.services;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mahendra.restdemo1.entities.Product;

@Component
@Scope("singleton")
public class ProductService {

	private List<Product> productList = new LinkedList<>();

	public ProductService() {
		productList.add(new Product("Samsung Smart TV ABC123", 1000, 32000D));
		productList.add(new Product("Panasonic Smart TV PNM123", 1001, 37000D));
	}
	
	public void insert(Product product) {
		if(isExists(product.getId())) {
			throw new RuntimeException("Product "+product.getId()+" Already exists!");
		}
	}
	
	public void delete(Product product) {
		if(! isExists(product.getId())) {
			throw new RuntimeException("Product "+product.getId()+" does not exists!");
		}
		Product p = findById(product.getId());
		productList.remove(p);
	}
	
	public List<Product > getAll(){
		// Return Unmodifiable list to controller 
		return Collections.unmodifiableList(productList);
	}
	
	public boolean isExists(Integer id) {
		boolean exist = false;
		for(Product p : productList) {
			if(p.getId().equals(id)) {
				exist = true;
			}
		}
		return exist;
	}
	
	public Product findById(int productId) {
		for(Product p : productList) {
			if(p.getId().equals(productId)) {
				return p;
			}
		}
		throw new RuntimeException("Product with id "+ productId+" doesnot exist!");
	}
}
