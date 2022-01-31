package com.mahendra.rsclient;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.mahendra.rsclient.entities.Product;
import com.mahendra.rsclient.entities.Todo;

@SpringBootApplication
public class RsClientApplication implements CommandLineRunner{

	
	static final String BASE_URL="https://jsonplaceholder.typicode.com";
	
	public static void main(String[] args) {
		SpringApplication.run(RsClientApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		RestTemplate template = new RestTemplate();
		Todo[] todos = template.getForObject(BASE_URL+"/todos", Todo[].class);
		System.out.println("Records found: "+todos.length);
		for(Todo t : todos) {
			if(t.isCompleted()) {
				System.out.println("Task : "+t.getId()+", "+t.getTitle());
			}
		}
		Todo t1 = new Todo();
		t1.setTitle("NOthing !");
		t1.setId(201);
		t1.setUserId(1);
		t1.setCompleted(true);
		
		Todo t2 = template.postForObject(BASE_URL+"/todos", t1, Todo.class );
		System.out.println("Record created !"+ t2.getId());
		
		Product p = new Product("Whirlpool Washing Machine", 1004, 18000D);
		
	
		String response = template.postForObject("http://localhost:9000/products", p, String.class);
		System.out.println(response);
	}

}
