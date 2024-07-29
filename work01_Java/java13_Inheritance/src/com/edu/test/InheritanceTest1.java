package com.edu.test;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.util.MyDate;

public class InheritanceTest1 {

	public static void main(String[] args) {
		//자식 클래스 생성
		Manager m = new Manager("James", 30000.0, new MyDate(1999, 1, 1), "IT");
		System.out.println(m.getDetails());
		
		Engineer eg = new Engineer("Tomas", 45000.0, new MyDate(1997, 3, 12), "Java", 100);
		System.out.println(eg.getDetails());
				
	}
}
