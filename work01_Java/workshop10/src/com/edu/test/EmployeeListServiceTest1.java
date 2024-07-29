package com.edu.test;

import com.edu.exception.DuplicateEmpIdException;
import com.edu.exception.RecordNotFoundException;
import com.edu.service.impl.EmployeeListServiceImpl;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;

public class EmployeeListServiceTest1 {

	public static void main(String[] args) {
		//1. Service 생성된 객체를 하나 받아온다..
		EmployeeListServiceImpl service = EmployeeListServiceImpl.getInstance();
				
				
		//2. method를 각각 호출..
		System.out.println("======================== 1. add ================================== ");
		Manager m1 = new Manager("111", "강호동", "방배동", 500, "개발부");
		Manager m2 =new Manager("222", "이수근","여의도",400,"오락부");
		Manager m3 =new Manager("333", "서장훈", "방배동", 600, "개발부");
		
		Engineer eg1 = new Engineer("444", "김희철", "신대방동", 450,"Python",100);
		Engineer eg2 =new Engineer("555", "이상민", "이태원", 500, "JS",300);
		
		System.out.println("============ Add ============");
		
		try {
			service.addEmployee(m1);
			service.addEmployee(m2);	
			service.addEmployee(m3);
			service.addEmployee(eg1);
			service.addEmployee(eg2);
			service.addEmployee(m3);
		} catch(DuplicateEmpIdException e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("============ Delete ============");
				
		try {
			service.deleteEmployee("22233");
		}catch(RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}
		service.findEmployees();

		
	
		//service.addEmployee(m3);
		
//		service.findEmployees();
				
//		System.out.println("======================== 2. delete ================================== ");
//		service.deleteEmployee("서장훈");
//		
//		service.findEmployees("서초동");
//	
//		System.out.println("========================");

	}
}
