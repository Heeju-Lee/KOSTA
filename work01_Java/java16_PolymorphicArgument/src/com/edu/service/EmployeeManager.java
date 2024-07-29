package com.edu.service;

import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;
import com.edu.vo.Secretary;

public class EmployeeManager {
	private static final int MAX_EMPLOYEES = 10;
	private Employee[] emps;
	private int currentEmps;
	
	static private EmployeeManager service = new EmployeeManager();//1
	private EmployeeManager() {
		emps = new Employee[MAX_EMPLOYEES];//비어있는 container임
		currentEmps = 0;
	}//2

	public static EmployeeManager getInstance() { //3
		return service;
	}


	public Employee[] findEmployee() {
		return emps;
	}

	public void addEmployee(Employee e) {
		if(currentEmps < MAX_EMPLOYEES)
			emps[currentEmps++]=e;
	}
		
	
	public Employee findEmployee(int empno) {
		for(Employee e : emps) {
			if(e==null)
				break;
			if(e.getEmpId()==empno)
				return e;//e를 반환.
		}
		return null;//for문안에서 끝나기 때문에 return null작동 x
	}
	
	public String getJob(Employee e) {
		if(e instanceof Engineer)
			return "기술자";
		if(e instanceof Secretary) 
			return "임원비서";
		if(e instanceof Manager)
			return "관리자";
		return "";
	}
	
	public Employee[] findEmployee(String addr) {
		Employee[] result = new Employee[MAX_EMPLOYEES];
		int index = 0;

		for (Employee e : emps) {
			if (e == null)
				break;
			if (e.getAddr().equals(addr))
				result[index++] = e;
		}

		return result;
	}


	public int getTotalCost() {
		int total = 0;
		for (Employee e : emps) {
			if (e == null)
				break;
			total += getAnnualSalary(e.getEmpId());
		}
		return total;
	}
	
	public int getAnnualSalary(int empId) {		
		int annualSalary  = 0;
		for(Employee e : emps) {
			if(e.getEmpId() == empId) {
				annualSalary+= e.getSalary() * 12;
				if(e instanceof Engineer)
					annualSalary += ((Engineer)e).getBonus();
				
				break;
			}			
		}//for		
			
		return annualSalary;
	}
	
}




























