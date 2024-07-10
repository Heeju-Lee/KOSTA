package com.self.vo;

import com.self.util.MyDate;

public class Manager {
	private String name;
	private MyDate birthDate;
	private double salary;
	private String dept;
	private int deptno;
	
	public static final double BASIC_SALARY = 30000;
	
	public Manager(String name, MyDate birthDate, double salary, String dept, int deptno) {
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
		this.dept = dept;
		this.deptno = deptno;
	}	
	
	public Manager(String name, MyDate birthDate, String dept, int deptno) {
		this.name = name;
		this.birthDate = birthDate;
		this.salary = BASIC_SALARY;
		this.dept = dept;
		this.deptno = deptno;
	}	
	
	public String getName() {
		return name;
	}

	public void changeSalary(double salary) {
		this.salary = salary;
	}
	
	public void changeDept(String dept) {
		this.dept = dept;
	}
	
	public void changeDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	public MyDate getBirthDate() {
		return birthDate;
	}
	
	public double getSalary() {
		return salary;
	}
	public String getDept() {
		return dept;
	}
	public int getDeptno() {
		return deptno;
	}
	public String getDetails() {
		return name+","+birthDate.getDate()+","+salary+","+dept+","+deptno;//getDate로 수정함. toString은 주소값을 반환함.
	}
}






