package com.edu.test;

import com.edu.dao.EmployeeDAOImpl;
import com.edu.exception.DMLException;
import com.edu.exception.DuplicateNumException;
import com.edu.exception.RecordNotFoundException;
import com.edu.vo.Employee;

public class EmployeeDAOTest {

	//메인 메소드
	public static void main(String[] args) throws Exception {
		EmployeeDAOImpl empDAO = EmployeeDAOImpl.getInstance();
		
		//3명삽입
		try {
			//empDAO.insertEmployee(new Employee(002,"JAMES", 1234.5,"LA"));
			empDAO.insertEmployee(new Employee(222,"TOMAS", 1550.4,"NY"));
			//empDAO.insertEmployee(new Employee(333,"JULIET", 1487.1,"LA"));
		}catch(DuplicateNumException e) {
			System.out.println(e.getMessage());
		}catch (DMLException e) {
			System.out.println(e.getMessage());
		}
		
		//전체검색
//		empDAO.selectEmployee();
		
		//num검색
//		empDAO.selectEmployee(111);
		
		//DELETE
		try {
			empDAO.removeEmployee(001);
		}catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (DMLException e) {
			System.out.println(e.getMessage());
		}
		
		empDAO.selectEmployee();//삭제되었는지 확인
		
		//수정
		
		try {
			empDAO.updateEmployee(new Employee("SCOTT", 1567.2, "NY"),111);	
		}catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (DMLException e) {
			System.out.println(e.getMessage());
		}

	}
}
