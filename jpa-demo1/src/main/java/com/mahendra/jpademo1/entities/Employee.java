package com.mahendra.jpademo1.entities;

import javax.persistence.*;

@Entity
@Table(name="emps")
public class Employee {

	@Id
	@Column(name="emp_id")
	private Integer empId;
	
	@Column(name="first_name", length=20)
	private String fname;
	
	@Column(name="last_name", length=20)
	private String lname;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
	
	
	
}
