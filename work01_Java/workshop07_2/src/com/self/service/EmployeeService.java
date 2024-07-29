package com.self.service;

import java.util.Arrays;

import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;
import com.self.vo.Secretary;

public class EmployeeService {
	
	Employee[] es;
	int eidx;
	
	// 싱글톤 패턴 적용..
	private static final EmployeeService service = new EmployeeService();
	
	// 싱글톤 패턴 적용... Constructor Overloading 기법 적용
	private EmployeeService() {
		this(10);
	}

	private EmployeeService(int size){
		es = new Employee[size];
	}
	
	// 싱글톤 패턴 적용...
	public static EmployeeService getInstance() {
		return service;
	}
	
	public void addEmployee(Employee e) {
		if(eidx<es.length) //추가
			es[eidx++] = e;
	}
	
	public void deleteEmployee(String name) {
		int tmpIndex = 0;
		for(int i = 0; i < eidx; i++) {
			// 값 삭제 대상이라면...
			if(es[i].getName().equals(name)) {
				tmpIndex = i;
				break;
			}			
		}
		
		while(tmpIndex < eidx - 1) {
			es[tmpIndex] = es[tmpIndex + 1];
			tmpIndex++;
		}
		
		es[tmpIndex] = null;
		eidx--;	
		System.out.println(name + "님이 제거되셨습니다.");
	}
	
	public void updateEmployee(Employee e) {
		int tmpIdx = 0;
				
		for(int i = 0; i < eidx; i++) {
			if (es[i].getName().equals(e.getName()))
				tmpIdx = i;
		}
		es[tmpIdx].changeSalary(e.getSalary());
		if(e instanceof Manager) {			
			((Manager)es[tmpIdx]).changeDept(((Manager)e).getDept());
			((Manager)es[tmpIdx]).changeDeptno(((Manager)e).getDeptno());
		} else if (e instanceof Engineer) {			
			((Engineer)es[tmpIdx]).changeTech(((Engineer)e).getTech());
			((Engineer)es[tmpIdx]).changeBonus(((Engineer)e).getBonus());
		} else if (e instanceof Secretary) {			
			((Secretary)es[tmpIdx]).changeNameOfBoss(((Secretary)e).getNameOfBoss());
		}
		
		System.out.println(e.getName() + "님의 정보가 수정되었습니다.");
	}
	
	public void printEmployee() {
		for(Employee e : es) {
			if(e==null) break;
			System.out.println("["+e.getClass().toString().substring(18)+"] " + e.toString());
		}
	}
	
	//Method Overloading
	/*
	 * 하는일은 똑같은데...처리하는 데이타를 달리할때 쓰는 기법
	 * 메소드의 통일감을 강조하면서도 서로다른 데이타를 처리할수 있게끔 해준다.
	 */
	//이름으로 직원 검색
	public Employee findEmployee(String name) {
		for(Employee e : es) {
			if(e == null) break;
			if(e.getName().equals(name)) {
				return e;
			}
		}
		
		return null;
	}
	
	//해당 급여 이상 받는 직원 검색
	public Employee[] findEmployee(double salary) {
		int count = 0;
		int tmpIdx = 0;
		
		for(Employee e : es) {
			if(e == null) break;
			if(e.getSalary() >= salary)
				count++;
		}
		
		Employee[] tmpEs = new Employee[count];
		
		for(Employee e : es) {
			if(e == null) break;
			if(e.getSalary() >= salary)
				tmpEs[tmpIdx++] = e;
		}
		
		return tmpEs;
	}
	
	//Employee 중에서 막내를 찾아 리턴 (아이디어 기능)
	public Employee findBabyOfEmployee() {
		int maxYear = 0;
		int maxMonth = 0;
		int maxDay = 0;
		int babyIndex = 0;
		
		for(int i = 0; i < eidx; i++) {
			String[] birthDay = es[i].getBirthDay().getDate().split("-");
			int year = Integer.parseInt(birthDay[0]);
			int month = Integer.parseInt(birthDay[1]);
			int day = Integer.parseInt(birthDay[2]);
						
			//막내를 구하는 로직... -> 년도, 월, 일 비교 로직
			if (year > maxYear) {
				maxYear = year;
				babyIndex = i;
			} else if (year == maxYear) {
				if(month > maxMonth) {
					maxMonth = month;
					babyIndex = i;
				} else if (month == maxMonth) {
					if(day > maxDay) {
						maxDay = day;
						babyIndex = i;
					}
				}
			}// if 조건문 끝
		}//for 반복문 끝
		return es[babyIndex];
	}
}