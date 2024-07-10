package com.self.test;

import com.self.service.EmployeeService;
import com.self.util.MyDate;
import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;
import com.self.vo.Secretary;

public class EmployeeServiceTest {
	public static void main(String[] args) {
		//1. Service 객체를 생성
		EmployeeService service = EmployeeService.getInstance();
				
		//2. method를 각각 호출..
		System.out.println("============ 1. addManager ============ ");
		service.addEmployee(new Manager("AAA", 20000.0, new MyDate(1978, 1, 1), "개발부", 10));
		service.addEmployee(new Manager("BBB", 34000.0, new MyDate(1975, 2, 1), "기획부", 20));
		service.addEmployee(new Manager("CCC", 20000.0, new MyDate(2000, 8, 23), "교육부", 30));
		service.addEmployee(new Manager("DDD", 40000.0, new MyDate(1999, 11, 16), "개발부", 30));
		
		System.out.println("\n============ 1. addEngineer ============ ");
		service.addEmployee(new Engineer("EEE", 35000.0, new MyDate(1995,3,4), "Java", 200.0));
		service.addEmployee(new Engineer("FFF", 40000.0, new MyDate(1979,7,5), "Java", 200.0));
		service.addEmployee(new Engineer("GGG", 40000.0, new MyDate(1988,8,8), "Python", 150.0));

		System.out.println("\n============ 1. addSecretary ============ ");
		service.addEmployee(new Secretary("HHH", 15000.0, new MyDate(2001,1,30), "King"));
		service.addEmployee(new Secretary("III", 18000.0, new MyDate(1999,2,22), "Tom"));
		service.addEmployee(new Secretary("JJJ", 31000.0, new MyDate(1990,9,1), "James"));
		
		System.out.println("============ Employee 정보확인 ============= ");
  		service.printEmployee();
		
		System.out.println("\n============ 2. deleteManager(AAA 삭제 + EEE 삭제 + III 삭제) ============ ");
		service.deleteEmployee("AAA");
		service.deleteEmployee("EEE");
		service.deleteEmployee("III");
		System.out.println("============ Employee 정보확인 ============= ");
		service.printEmployee();
		
		System.out.println("\n============ 3. updateManager(CCC 연봉 수정 200->350, GGG 보너스 수정 150 -> 200) ============ ");
		service.updateEmployee(new Manager("CCC", 35000.0, new MyDate(2000, 8, 23), "교육부", 30));
		service.updateEmployee(new Engineer("GGG", 40000.0, new MyDate(1988,8,8), "Python", 200.0));
		
		
		System.out.println("============ Employee 정보확인 ============= ");
		service.printEmployee();
		
		
		System.out.println("\n============ 4. findManager(CCC, JJJ) ============ ");
		Employee retM1 = service.findEmployee("CCC");
		Employee retM2 = service.findEmployee("JJJ");
		System.out.println(retM1.toString());
		System.out.println(retM2.toString());
		
		System.out.println("\n============ 4. findManager(35000) 35000원 이상 직원 검색 ============ ");
		for(Employee e : service.findEmployee(35000))
			System.out.println(e.toString());
	
		
		System.out.println("\n============ 5. findBabyOfEmployee() ============ ");
		System.out.println("직원 중 막내의 정보입니다. >>>");
		System.out.println("["+service.findBabyOfEmployee().getClass().toString().substring(18)+"] " + service.findBabyOfEmployee().toString());
	}
}







