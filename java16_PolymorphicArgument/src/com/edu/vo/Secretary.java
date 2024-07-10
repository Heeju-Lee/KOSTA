package com.edu.vo;

public class Secretary extends Employee{

	private String bossOfName;

	public Secretary(int empId, String name, String addr, int salary,String bossOfName) {
		super(empId, name, addr, salary);
		this.bossOfName = bossOfName;		
	}
	
	public String getBossOfName() {
		return bossOfName;
	}
	public void setBossOfName(String bossOfName) {
		this.bossOfName = bossOfName;
	}

	@Override
	public String toString() {
		return super.toString()+"Secretary [bossOfName=" + bossOfName + "]";
	}
	
	
}
