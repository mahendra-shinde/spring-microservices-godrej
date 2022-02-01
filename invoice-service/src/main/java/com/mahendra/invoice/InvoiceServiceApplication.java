package com.mahendra.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class InvoiceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceServiceApplication.class, args);
	}
	
	@Bean		// This one is "Spring Managed Component"
	@LoadBalanced  // Service name would be translated into hostname
	public RestTemplate template() {
		return new RestTemplate();
	}

}
