package com.mahendra.dynamo;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class DynamoDemo1Application{

	/*
	 * @Autowired private AmazonDynamoDB db; private DynamoDBMapper mapper;
	 * 
	 * @Autowired private EmployeeRepo repo;
	 */

	public static void main(String[] args) {
		SpringApplication.run(DynamoDemo1Application.class, args);
	}

	
	
	/*
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
		
	} */

}
