package com.mahendra.dynamo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper.FailedBatch;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ResourceInUseException;
import com.mahendra.dynamo.dao.EmployeeRepo;
import com.mahendra.dynamo.entities.Employee;

@SpringBootApplication
public class DynamoDemo1Application implements CommandLineRunner {

	@Autowired
	private AmazonDynamoDB db;
	private DynamoDBMapper mapper;
	
	@Autowired private EmployeeRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(DynamoDemo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mapper = new DynamoDBMapper(db);
		CreateTableRequest createTable = mapper.generateCreateTableRequest(Employee.class);
		createTable.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
		System.out.println("Creating a new table (collection of entities)");

		try {
			CreateTableResult result = db.createTable(createTable);
			System.out.println(result);
		} catch (ResourceInUseException ex) {
			System.out.println("Cannot create table :" + ex.getMessage());
		}
		
		Employee emp1 = new Employee();
		emp1.setFirstName("Joe");
		emp1.setLastName("Biden");
		
		List<FailedBatch> result= mapper.batchSave(emp1);
		if(result.size()==0)
			System.out.println("Written Successfuly!");
		
		System.out.println("Find records");
		
		Iterable<Employee> emps = repo.findAll();
		System.out.println("Found employees: ");
		for(Employee e: emps) {
			System.out.println(e.getFirstName()+" ,"+e.getLastName()+", "+e.getEmpId());
		}
		
	}

}
