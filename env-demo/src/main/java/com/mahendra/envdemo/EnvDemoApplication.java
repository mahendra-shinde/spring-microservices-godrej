package com.mahendra.envdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnvDemoApplication implements CommandLineRunner{

	@Value("${myname}")
	private String myname;
	
	@Value("${mycity}")
	private String mycity;
	
	
	public static void main(String[] args) {
		SpringApplication.run(EnvDemoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
	
		System.out.println("Hello World, I am "+myname+" from "+mycity);
	}

}
