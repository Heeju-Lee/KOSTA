package com.self.vo;

import com.self.parent.Employee;
import com.self.util.MyDate;

public class Secretary extends Employee{
	private String nameOfBoss;


	public Secretary(String name, MyDate myDate, double salary, String nameOfBoss) {
		super(name, myDate, salary);
		this.nameOfBoss = nameOfBoss;
	}
	
	public Secretary(String name, MyDate myDate, String nameOfBoss) {
		super(name, myDate);
		this.nameOfBoss = nameOfBoss;
	}

	public String getNameOfBoss() {
		return nameOfBoss;
	}

	public void changeNameOfBoss(String nameOfBoss) {
		this.nameOfBoss = nameOfBoss;
	}

	public String toString() {
		return super.toString()+", Name of Boss :"+nameOfBoss;
	}
}