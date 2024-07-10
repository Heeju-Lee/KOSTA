package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Secretary extends Employee {
	
	private String nameOfBoss;

	public Secretary() {}

	public Secretary(String name, double salary, MyDate birthDate,String nameOfBoss) {
		super(name, salary, birthDate);
		this.nameOfBoss = nameOfBoss;
	}
	
	public String getNameOfBoss() {
		return nameOfBoss;
	}

	public void changeNameOfBoss(String nameOfBoss) {
		this.nameOfBoss = nameOfBoss;
	}

	
	public String toString() {
		
		return super.toString()+", nameOfBoss: "+nameOfBoss;
	
	}
	
}
