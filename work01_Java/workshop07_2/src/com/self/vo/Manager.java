package com.self.vo;

import com.self.util.MyDate;

public class Manager extends Employee {
	
	private String dept;
	private int deptno;
	
	public Manager(String name, double salary, MyDate birthDate, String dept, int deptno) {
		super(name, salary, birthDate);
		this.dept = dept;
		this.deptno = deptno;
	}
	
	public String getDept() {
		return dept;
	}

	public void changeDept(String dept) {
		this.dept = dept;
	}

	public int getDeptno() {
		return deptno;
	}

	public void changeDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", " + dept + ", " + deptno;
	}
}






