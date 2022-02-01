package com.mahendra.invoice.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mahendra.invoice.entities.Product;

@RestController
@RequestMapping("/")
public class TestResource {

	@Autowired RestTemplate template;
	
	@GetMapping
	public List<Product> callProduct() {
		// The URL http://product-api/products will be "translated" http://localhost:51000/products
		// Assuming Server Port for "productservice" was 51000
		Product[] products = template.getForObject("http://product-api/products", Product[].class);
		String respo="Loaded "+products.length+" products";
		System.out.println(respo);
		return Arrays.asList(products);
	}
}
