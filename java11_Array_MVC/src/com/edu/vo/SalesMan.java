package com.edu.vo;

import com.edu.util.MyDate;

public class SalesMan {
	private String name;
	private double salary;
	private double commition;
	private MyDate birthDate;
	
	public SalesMan(){}
	public SalesMan(String name, double salary, double commition, MyDate birthDate) {
		this.name = name;
		this.salary = salary;
		this.commition = commition;
		this.birthDate = birthDate;
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
	public double getCommition() {
		return commition;
	}
	public void setCommition(double commition) {
		this.commition = commition;
	}
	public MyDate getBirthDate() {
		return birthDate;
	}

	public String getDetails() {
		return name+","+salary+","+commition;
	}
	
}
