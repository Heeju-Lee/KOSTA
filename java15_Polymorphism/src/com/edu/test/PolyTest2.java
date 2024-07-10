package com.edu.test;

import java.util.Arrays;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class PolyTest2 {

	public static void main(String[] args) {
		//이기종간의 집합체 hetero geneous collection
		Employee[] employees = {
				new Manager("James", 30000.0, new MyDate(1999, 1, 1), "IT"),
				new Engineer("Tomas", 45000.0, new MyDate(1997, 3, 12), "Java", 100),
				new Secretary("Peter", 35000.0, new MyDate(2000, 4, 3), "James"),
				new Manager("James2", 30000.0, new MyDate(1999, 1, 1), "IT2"),
				new Engineer("Tomas2", 45000.0, new MyDate(1997, 3, 12), "Java2", 100)
		};
		for(Employee e : employees) {
			System.out.println(e.toString());
			}
		//배열안에 들어있는 데이터의 요소를 출력....Arrays.toString()
		System.out.println(Arrays.toString(employees));
		
		System.out.println("=============employees 안에서 관리되는 직원들의 연봉 :: 잘못된 결과 =============");
		int annualSalary =0;
		for(Employee e : employees) {
			annualSalary = (int) ((double)e.getSalary()*12);
			System.out.println(e.getName()+" 님의 연봉은 "+annualSalary+"달러입니다.");//산출방식이 각각 다름.
		}
		
		System.out.println("=============employees 안에서 관리되는 직원들의 연봉 :: Success 결과 =============");
		int total =0;
		for(Employee e : employees) {
			if(e instanceof Engineer) {
				System.out.println("Infomation :: "+e.toString());
				total = (int) ((double)e.getSalary()*12)+((Engineer)e).getBonus();//캐스팅
			}
			else {
			total = (int) ((double)e.getSalary()*12);}
			
			System.out.println(e.getName()+" 님의 연봉은 "+total+"달러입니다.");//산출방식이 각각 다름.
		}
		
	}//main
}//class
