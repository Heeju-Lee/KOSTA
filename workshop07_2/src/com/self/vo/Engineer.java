package com.self.vo;

import com.self.util.MyDate;

public class Engineer extends Employee {
	private String tech;
	private double bonus;
	
	public Engineer(String name, double salary, MyDate birthDate, String tech, double bonus) {
		super(name, salary, birthDate);
		this.tech = tech;
		this.bonus = bonus;
	}	
	
	public String getTech() {
		return tech;
	}

	public void changeTech(String tech) {
		this.tech = tech;
	}

	public double getBonus() {
		return bonus;
	}

	public void changeBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + tech + ", " + bonus;
	}	
}
