package com.self.vo;

import com.self.util.MyDate;

public class Employee {
	private String name;
	private double salary;
	private MyDate birthDay;
	
	public Employee(String name, double salary, MyDate birthDay) {
		super();
		this.name = name;
		this.salary = salary;
		this.birthDay = birthDay;
	}
	
	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public void changeSalary(double salary) {
		this.salary = salary;
	}

	public MyDate getBirthDay() {
		return birthDay;
	}
	
	public String toString() {
		return name + ", " + salary + ", " + birthDay.getDate();
	}
}
