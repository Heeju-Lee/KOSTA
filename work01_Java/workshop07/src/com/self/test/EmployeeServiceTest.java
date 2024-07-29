package com.self.test;

import java.util.Arrays;

import com.self.parent.Employee;
import com.self.service.EmployeeService;
import com.self.util.MyDate;
import com.self.vo.Engineer;
import com.self.vo.Manager;
import com.self.vo.Secretary;

public class EmployeeServiceTest {

	public static void main(String[] args) {
		//1. Service 객체를 생성
		EmployeeService service = new EmployeeService(10);
		
		//2. method를 각각 호출..
		System.out.println("============ 1. addEmployee ============\n");
		
		service.addEmployee(new Manager("AAA", new MyDate(1978, 1, 1), 20000.0, "개발부", 10));
		service.addEmployee(new Manager("BBB", new MyDate(1975, 2, 1), 34000.0, "기획부", 20));
		service.addEmployee(new Manager("CCC", new MyDate(1980, 3, 3), 20000.0, "교육부", 30));
		service.addEmployee(new Manager("DDD", new MyDate(1995, 8, 1), 37000.0, "개발부", 10));
		service.addEmployee(new Engineer("EEE", new MyDate(1995,3,4), 35000.0, "Java", 200.0));
		service.addEmployee(new Engineer("FFF", new MyDate(1995,7,2), 35000.0, "Java", 200.0));
		service.addEmployee(new Engineer("GGG", new MyDate(1994,11,2), 45000.0, "Python", 300.0));
		service.addEmployee(new Secretary("LHJ", new MyDate(1996,11,26), 60000.0,"Jeolme"));
		
		System.out.println("\n============ Manager list ============\n");
		service.printEmployee("Manager");
		
		System.out.println("\n============ Engineer list ============\n");
		service.printEmployee("Engineer");

		System.out.println("\n============ Secretary list ============\n");
		service.printEmployee("Secretary");
		
		System.out.println("\n============ 2. DeleteEmployee ============\n");//(Manager AAA 삭제) 
		service.deleteEmployee("AAA");
		
		System.out.println("\n============ Manager list ============\n");//(Manager AAA 삭제 후) 
		service.printEmployee("Manager");

		System.out.println("\n============ 3. updateManager(CCC 연봉 수정 20000->35000) ============\n");
		service.updateEmployee(new Manager("CCC", new MyDate(1980, 3, 3), 35000.0, "교육부", 30));
		
		System.out.println("\n============ 4. findEmployee(Name : BBB) ============\n ");
		service.findEmployee("BBB");
		
		System.out.println("\n============ 4. findEmployee(Deptno : 10) ============\n ");
		System.out.println(">>>>10번 부서에 근무하는 직원들 입니다.");
		service.findEmployee(10);
		
		
		System.out.println("\n============ Employee list ============\n");
		service.printEmployee("All");
		
		System.out.println("\n============ 4. findEmployee(Name : EEE) ============\n ");
		service.findEmployee("EEE");
		
		System.out.println("\n============ 5. Salary Information ============\n ");
		service.salaryInfoEmployee("Manager");
		service.salaryInfoEmployee("Engineer");
		service.salaryInfoEmployee("Secretary");
		
		System.out.println("\n============ 6. Headcount ============\n ");
		service.countEmployee("Manager");
		service.countEmployee("Engineer");
		service.countEmployee("Secretary");
		service.countEmployee("All");
		
		//싱글톤 활용...
		System.out.println("\n============ 7. Register Groupware ============\n ");
		EmployeeService.getInstance().register("CCC");
		EmployeeService.getInstance().register("DDD");
		EmployeeService.getInstance().register("EEE");
		
	}
}









