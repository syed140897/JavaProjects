package com.creativemind.EmployeeDataSpring.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class EmployeeDetailList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String salary;
	private String role;
	private Boolean fresher;
	
	
	public EmployeeDetailList() {
		super();
	}
	public EmployeeDetailList(Integer id, String name, String salary, String role, Boolean fresher) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.role = role;
		this.fresher = fresher;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Boolean getFresher() {
		return fresher;
	}
	public void setFresher(Boolean fresher) {
		this.fresher = fresher;
	}
	@Override
	public String toString() {
		return "EmployeeDetailList [id=" + id + ", name=" + name + ", salary=" + salary + ", role=" + role
				+ ", fresher=" + fresher + "]";
	}
	
	
}
