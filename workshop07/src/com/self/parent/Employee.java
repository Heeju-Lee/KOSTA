package com.self.parent;

import com.self.util.MyDate;

public class Employee {
	private String name;
	private MyDate myDate;
	private double salary;
	
	public static final double BASIC_SALARY = 30000;
	
	public Employee() {	}
	
	public Employee(String name, MyDate myDate,double salary) {
		this.name = name;
		this.myDate = myDate;
		this.salary = salary;
	}
	
	public Employee(String name, MyDate myDate) {
		this.name = name;
		this.myDate = myDate;
		this.salary = BASIC_SALARY;
	}
		
	public String getName() {
		return name;
	}

	public MyDate getMyDate() {
		return myDate;
	}
	
	public double getSalary() {
		return salary;
	}

	public void changeSalary(double salary) {
		this.salary = salary;
	}

	public String toString() {
		return "name : "+name+", BirthDate: "+myDate.getDate()+", Salary: "+salary;
	}
	
}
