package com.mahendra.dynamo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mahendra.dynamo.dao.EmployeeRepo;
import com.mahendra.dynamo.entities.Employee;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping(value="/api/employees")
public class EmployeeResource {
	
	@Autowired private EmployeeRepo repo;
	
	public EmployeeResource() {
	
	}
	
	
	@GetMapping(produces="application/json")
	public List<Employee> getAll(){
		List<Employee> temp = new ArrayList<>();
		repo.findAll().forEach(e -> temp.add(e));
		System.out.println("Records found : "+temp.size());
		return temp;
	}
	
	@PostMapping
	public String create(@RequestBody Employee emp) {
		Employee e1 = repo.save(emp);
		System.out.println("Employee ID: " + e1.getEmpId());
		return "SUCCESS";
	}
}
