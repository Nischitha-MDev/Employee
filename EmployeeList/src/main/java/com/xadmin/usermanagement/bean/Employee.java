package com.xadmin.usermanagement.bean;

public class Employee {
	private int id;
	private String name;
	private String email;
	private String Designation;
	private String Department;
	
	public Employee() {
	
	}

	public Employee(String name, String email, String designation, String department) {
		super();
		this.name = name;
		this.email = email;
		this.Designation = designation;
		this.Department = department;
	}
	public Employee(int id, String name, String email, String designation, String department) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.Designation = designation;
		this.Department = department;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	
	
	
}
