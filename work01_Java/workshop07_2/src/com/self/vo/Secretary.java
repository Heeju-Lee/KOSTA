package com.self.vo;

import com.self.util.MyDate;

public class Secretary extends Employee {
	
	private String nameOfBoss;
	
	public Secretary(String name, double salary, MyDate birthDay, String nameOfBoss) {
		super(name, salary, birthDay);
		this.nameOfBoss = nameOfBoss;
	}
	
	public String getNameOfBoss() {
		return nameOfBoss;
	}

	public void changeNameOfBoss(String nameOfBoss) {
		this.nameOfBoss = nameOfBoss;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + nameOfBoss;
	}
}
