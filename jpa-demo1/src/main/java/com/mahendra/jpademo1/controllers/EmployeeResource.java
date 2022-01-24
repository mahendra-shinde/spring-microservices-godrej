package com.mahendra.jpademo1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahendra.jpademo1.daos.EmployeeDAO;
import com.mahendra.jpademo1.entities.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {

	@Autowired EmployeeDAO dao;
	
	@PostMapping(consumes="application/json")
	public String create(@RequestBody Employee emp) {
		dao.save(emp);
		return "Created a record";
	}
	
	@GetMapping(produces="application/json")
	public List<Employee> getAll(){
		return dao.findAll();
	}
}
