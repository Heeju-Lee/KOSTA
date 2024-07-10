package com.edu.parent;

import com.edu.util.MyDate;

//부모클래스
public class Employee {
	private String name;
	private double salary;
	private MyDate birthDate;

	public Employee () {}	
	public Employee(String name, double salary, MyDate birthDate) {
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public MyDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(MyDate birthDate) {
		this.birthDate = birthDate;
	}
	//추가 
	
	
	public String toString() {//선언부는 고칠 수 없음
		//birthdate뒤에 tostring이 붙어있어서 주소값이 나오는데 그래서 뒤에 getxxx 리턴값을 넣어줘야 함.
		return name+","+salary+","+birthDate.getDate();
	}	

}
