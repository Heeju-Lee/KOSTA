package com.self.vo;

import com.self.util.MyDate;

public class Engineer {
	private String name;
	private MyDate birthDate;
	private double salary;
	private String tech;
	private double bonus;
	
	public Engineer(String name, MyDate birthDate, double salary, String tech, double bonus) {
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
		this.tech = tech;
		this.bonus = bonus;
	}	
	public String getName() {
		return name;
	}	
	public void changeSalary(double salary) {
		this.salary = salary;
	}
	public void changeTech(String tech) {
		this.tech = tech;
	}
	public void changeBonus(double bonus) {
		this.bonus = bonus;
	}	
	public double getSalary() {
		return salary;
	}
	public String getTech() {
		return tech;
	}
	public double getBonus() {
		return bonus;
	}
	public MyDate getBirthDate() {
		return birthDate;
	}
	public String getDetails() {
		return name+","+birthDate.getDate()+","+salary+","+tech+","+bonus;
	}	
}
