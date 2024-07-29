package com.edu.vo;

import com.edu.util.MyDate;

public class Engineer {
	private String name;
	private double salary;
	private String mainSkill;
	private MyDate birthDate;
	

	public Engineer(){}
	
	public Engineer(String name, double salary, String mainSkill, MyDate birthDate) {
		this.name = name;
		this.salary = salary;
		this.mainSkill = mainSkill;
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

	public String getMainSkill() {
		return mainSkill;
	}

	public void developMainSkill(String mainSkill) {
		this.mainSkill = mainSkill;
	}

	public MyDate getBirthDate() {
		return birthDate;
	}
	
	public String getDetails() {
		return name+","+salary+","+mainSkill;
	}
	
}
