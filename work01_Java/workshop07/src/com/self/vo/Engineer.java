package com.self.vo;

import com.self.parent.Employee;
import com.self.util.MyDate;

public class Engineer extends Employee {
	private String tech;
	private double bonus;
	
	public Engineer(String name, MyDate myDate, double salary, String tech, double bonus) {
		super(name, myDate, salary);
		this.tech = tech;
		this.bonus = bonus;
	}
	
	public Engineer(String name, MyDate myDate, String tech, double bonus) {
		super(name, myDate);
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

	public String toString() {
		return super.toString()+", tech : "+tech+"bonus :"+bonus;
	}	
}
