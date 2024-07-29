package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Manager extends Employee{
	
	private String dept;

	public Manager(String name, double salary, MyDate birthDate, String dept) {
		super(name, salary, birthDate);//부모의 것
		this.dept = dept;//자식의 것
	}//부모-자식
	
	public String getDetails() {//선언부는 고칠 수 없음.
		//부모가 물려준 기능을 자식한테 맞게 변경함. 메소드 재정의 (method overriding)
		return super.getDetails()+","+dept;
	}		
	
	public void manage() {
		System.out.println("Manager....");
	}
}
	
