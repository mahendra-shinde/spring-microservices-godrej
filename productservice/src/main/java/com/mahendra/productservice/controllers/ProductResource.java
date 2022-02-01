package com.mahendra.productservice.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mahendra.productservice.entities.Product;
import com.mahendra.productservice.services.ProductService;

import ch.qos.logback.core.joran.spi.NoAutoStart;

@RestController
@RequestMapping(value = "/products", produces = { "application/json", "application/xml" })
public class ProductResource {

	// Spring IoC to INJECT Single copy of "ProductService" here !!!
	@Autowired private ProductService service;
	
	public ProductResource() {
		

	}

	/// The final url-endpoint
	/// http://localhost:9000/products/
	@GetMapping
	public List<Product> getAll() {
		return service.getAll();
	}

	/// The final url-endpoint
	/// http://localhost:9000/products/1000
	@GetMapping(value = "/{id}")
	public Product findProduct(@PathVariable("id") Integer id) {
		System.out.println("Path Varable : " + id);
		return service.findById(id);
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<String> create(@RequestBody Product product) {
		System.out.println("Creating a new product....");
		System.out.println("Name: " + product.getName());
		service.insert(product);
		return new ResponseEntity<String>("Created new product", HttpStatus.CREATED);
	}
	
	
	// Endpoint: DELETE http://localhost:9000/products?id=1000 
	@DeleteMapping
	public ResponseEntity<String> deleteById(@RequestParam("id")Integer id){
		System.out.println("Deleting record "+id);
		Product p = service.findById(id);
		service.delete(p);
		return new ResponseEntity<String>("Product "+id+" deleted successfuly",HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}",consumes="application/json")
	public ResponseEntity<Product> update(@PathVariable("id") Integer id, @RequestBody Product p){
		System.out.println("Updating product id "+id);
		Product temp = service.findById(id);
		temp.setName(p.getName());
		temp.setPrice(p.getPrice());
		return new ResponseEntity<Product>(temp,HttpStatus.OK);
		
	}
}
