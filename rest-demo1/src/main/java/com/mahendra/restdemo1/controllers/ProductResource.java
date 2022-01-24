package com.mahendra.restdemo1.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mahendra.restdemo1.entities.Product;

@RestController
@RequestMapping(value = "/products", produces = { "application/json", "application/xml" })
public class ProductResource {

	private List<Product> productList = new LinkedList<>();

	public ProductResource() {
		productList.add(new Product("Samsung Smart TV ABC123", 1000, 32000D));
		productList.add(new Product("Panasonic Smart TV PNM123", 1001, 37000D));

	}

	/// The final url-endpoint
	/// http://localhost:9000/products/
	@GetMapping
	public List<Product> getAll() {
		return productList;
	}

	/// The final url-endpoint
	/// http://localhost:9000/products/1000
	@GetMapping(value = "/{id}")
	public Product findProduct(@PathVariable("id") Integer id) {
		System.out.println("Path Varable : " + id);
		return findById(id);
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<String> create(@RequestBody Product product) {
		System.out.println("Creating a new product....");
		System.out.println("Name: " + product.getName());
		productList.add(product);
		return new ResponseEntity<String>("Created new product", HttpStatus.CREATED);
	}
	
	private Product findById(Integer id) {
		for (Product p : productList) {
			if (p.getId().equals(id)) {
				System.out.println("Product : " + p.getName());
				return p;
			}
		}
		return null;
	}
	
	// Endpoint: DELETE http://localhost:9000/products?id=1000 
	@DeleteMapping
	public ResponseEntity<String> deleteById(@RequestParam("id")Integer id){
		System.out.println("Deleting record "+id);
		Product p = findById(id);
		if(p == null) {
			return new ResponseEntity<String>("Product Id:"+id+" was not found", HttpStatus.NOT_FOUND);
		}
		productList.remove(p);
		return new ResponseEntity<String>("Product "+id+" deleted successfuly",HttpStatus.OK);
	}
	
}
