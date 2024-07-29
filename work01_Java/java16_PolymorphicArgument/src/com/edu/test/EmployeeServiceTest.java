package com.edu.test;

import java.util.Arrays;

import com.edu.service.EmployeeService;
import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;
import com.edu.vo.Secretary;

public class EmployeeServiceTest {
	public static void main(String[] args) {	
		Manager m = new Manager(1234, "AAA", "천호동", 320, "개발부");
		Engineer eg = new Engineer(5566, "BBB", "판교", 100, "JAVA", 500);
		Engineer eg1 = new Engineer(7090, "CCC", "판교", 400, "NodeJS", 50);
		Secretary s = new Secretary(7369,"DDD", "상일동", 450, "AAA");
		
		Employee[ ] emps = {m, eg, eg1, s};		

		EmployeeService service= EmployeeService.getInstance();
		
		
		System.out.println("\n*****1. getAllEmployee calling *******");
				
		Employee[ ] ea=service.getAllEmployee(emps); 
		for(Employee e : ea)System.out.println(e);
		 
			
		System.out.println("\n*****2.findEmployee calling *******");
		System.out.println(service.findEmployee(emps, 5566));///polymorphic argument
		

		System.out.println("\n*****3. findEmployee calling *******");
		System.out.println(Arrays.toString(service.findEmployee(emps, "판교")));
		

		System.out.println("\n*****4. getAnnualSalary calling *******");
		System.out.println("Anuual Salary :: "+service.getAnnualSalary(ea[0]));
		System.out.println("Anuual Salary :: "+service.getAnnualSalary(ea[2]));
		
				
		System.out.println("\n*****5. getTotalCost calling *******");
		System.out.println("[모든 고용인들의 연간 총 인건비는 ::]"
									+service.getTotalCost(ea));
		
	}
}






















