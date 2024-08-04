package com.edu.test;

import java.sql.SQLException;

import com.edu.dao.EmployeeDAOImpl;
import com.edu.exception.DuplicateNumException;
import com.edu.vo.Employee;

public class EmployeeDAOTest {

	//메인 메소드
	public static void main(String[] args) throws Exception {
		EmployeeDAOImpl empDAO = EmployeeDAOImpl.getInstance();
		
		//3명삽입
//		empDAO.insertEmployee(new Employee(002,"JAMES", 1234.5,"LA"));
		//empDAO.insertEmployee(new Employee(222,"TOMAS", 1550.4,"NY"));
		//empDAO.insertEmployee(new Employee(333,"JULIET", 1487.1,"LA"));
		
		//전체검색
//		empDAO.selectEmployee();
		
		//num검색
//		empDAO.selectEmployee(111);
		
		//DELETE
		empDAO.removeEmployee(001);
		empDAO.selectEmployee();//삭제되었는지 확인
		
		//수정
		empDAO.updateEmployee(new Employee("SCOTT", 1567.2, "NY"),111);	
	}
}
