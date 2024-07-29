package com.self.vo;

import com.self.parent.Employee;
import com.self.util.MyDate;

public class Manager extends Employee{
	private String dept;
	private int deptno;
	
	

	public Manager(String name, MyDate myDate, double salary, String dept, int deptno) {
		super(name, myDate, salary);
		this.dept = dept;
		this.deptno = deptno;
	}
	
	public Manager(String name, MyDate myDate, String dept, int deptno) {
		super(name, myDate);
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

	public String toString() {
		return super.toString()+", dept :"+dept+", deptno :"+deptno;
	}
}






