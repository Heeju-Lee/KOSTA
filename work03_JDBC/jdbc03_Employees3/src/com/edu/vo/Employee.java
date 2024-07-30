package com.edu.vo;

public class Employee {
	private int num;
	private String name;
	private double salary;
	private String address;
	
	
	public Employee(){}
	public Employee(int num, String name, double salary, String address) {
		super();
		this.num = num;
		this.name = name;
		this.salary = salary;
		this.address = address;
	}

	public Employee(String name, double salary, String address) {
		super();
		this.name = name;
		this.salary = salary;
		this.address = address;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Employee [num=" + num + ", name=" + name + ", salary=" + salary + ", address=" + address + "]";
	}

}
