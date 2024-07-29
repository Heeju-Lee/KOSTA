package com.edu.service;

import java.util.ArrayList;

import com.edu.exception.DuplicateEmpIdException;
import com.edu.exception.RecordNotFoundException;
import com.edu.vo.Employee;

//기능의 Template을 모아놓은 인터페이스....
public interface EmployeeListService {
	void addEmployee(Employee e) throws DuplicateEmpIdException;//public abstract가 생략....
	void deleteEmployee(String empId) throws RecordNotFoundException;
	void updateEmployee(Employee e) throws RecordNotFoundException;
	
	//Method Overloading
	ArrayList<Employee> findEmployees(String addr);
	void findEmployees();
}
