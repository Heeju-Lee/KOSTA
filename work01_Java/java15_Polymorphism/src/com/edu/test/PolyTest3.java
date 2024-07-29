package com.edu.test;

import java.util.Arrays;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class PolyTest3 {

	public static void main(String[] args) {
		//이기종간의 집합체 hetero geneous collection
		Employee[] employees = {
				new Manager("James", 30000.0, new MyDate(1999, 1, 1), "IT"),
				new Engineer("Tomas", 45000.0, new MyDate(1997, 3, 12), "Java", 100),
				new Secretary("Peter", 35000.0, new MyDate(2000, 4, 3), "James"),
		};
	/*
	 for문과 instanceof, Object casting, virture Method Invocation 전부 다 사용
	 
	 James 부서를 "개발부"로 수정
	 Tomas 기술을 "AI" 기술로 수정
	 Peter Boss의 이름을 "Gosling"으로 수정
	 
	 수정된 정보를 출력....확인
	 */
		///////////////////////////////////////////////////////////////////////////////
		/*
		1step
		updateManager(Manager m) {}
		updateEngineer(Engineer eg) {}
		
		2step
		updateEmployee(Manager m) {}
		updateEmployee(Engineer eg) {} 
		
		3step
		updateEmployee(Employee e) {// 상속 & 다형성 / 인자값에 부모가 들어가면 다형성 인자값(자식값다 넣을 수 있음)
			if(e instanceof Manager){}
			if(e instanceof Engineer){}
		 */

		for(Employee e : employees) {
			if(e instanceof Manager) {
				((Manager) e).changeDept("개발부");
			}
			else if(e instanceof Engineer) {
				((Engineer) e).changeTech("AI");
			}else if(e instanceof Secretary) {
				((Secretary) e).changeNameOfBoss("Gosiling");
			}
			
			System.out.println(e.toString());;
		}
		
	}//main
}//class
