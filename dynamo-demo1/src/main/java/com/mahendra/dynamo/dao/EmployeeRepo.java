package com.mahendra.dynamo.dao;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.mahendra.dynamo.entities.Employee;

@EnableScan
public interface EmployeeRepo extends CrudRepository<Employee, String>{
	
}
