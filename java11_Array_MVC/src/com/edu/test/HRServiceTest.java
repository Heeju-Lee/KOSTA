package com.edu.test;

import com.edu.service.HRService;
import com.edu.util.MyDate;
import com.edu.vo.Engineer;
import com.edu.vo.SalesMan;

public class HRServiceTest {

	public static void main(String[] args) {
		HRService service = new HRService(5);
		
		Engineer e1 = new Engineer("James", 30000.0, "Java", new MyDate(1998, 1, 1));
		Engineer e2 = new Engineer("Juliet", 45000.0, "Python", new MyDate(1997, 3, 11));
		Engineer e3 = new Engineer("Tomas", 53000.0, "AI", new MyDate(1990, 2, 1));
		SalesMan s = new SalesMan("Peter", 56666, 1000, new MyDate(1992, 3, 1));
		
		//서비스 기능 호출..
		System.out.println("========== 1. addEmployee ==================");
		service.addEmployee(e1);
		service.addEmployee(e2);
		service.addEmployee(e3);
		service.addEmployee(s);
		
		System.out.println("========== 2. Employee 정보 확인 ==================");
		service.printEngineer();
		service.printSalesMan();
		
		System.out.println("========== 3. updateEmployee Engineer ==================");
		e2 = new Engineer("Juliet", 75000.0, "ReAct", new MyDate(1997, 3, 11));
		service.updateEmployee(e2);
		
		System.out.println("========== 4. Employee 정보 확인 ==================");
		service.printEngineer();
		service.printSalesMan();
		
		System.out.println("========== 5.searchEmployee  Tomas==================");
		Engineer returnEngineer=service.searchEmployee("Tomas");
		System.out.println(returnEngineer.getDetails());
	}
}
