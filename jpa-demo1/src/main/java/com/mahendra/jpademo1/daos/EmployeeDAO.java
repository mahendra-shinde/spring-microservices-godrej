package com.mahendra.jpademo1.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mahendra.jpademo1.entities.Employee;

@Repository // Spring Data-JPA will provide "implementation" of this interface !
public interface EmployeeDAO extends CrudRepository<Employee, Integer>{
  /// no need of any code
	@Query("select e from Employee e")
	public List<Employee> findAll();
}
