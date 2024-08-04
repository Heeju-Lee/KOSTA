package com.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.vo.Employee;

public interface EmployeeDAO {
	
	public Connection getConnect() throws Exception;
	public void closeAll(PreparedStatement ps, Connection conn) throws Exception;
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws Exception;
	public void insertEmployee(Employee emp) throws Exception;
	public void removeEmployee(int num) throws Exception;
	public ArrayList<Employee> selectEmployee() throws Exception;
	public Employee selectEmployee(int num) throws Exception;
	void updateEmployee(Employee emp, int num) throws Exception;
	private boolean isExist(int num) throws Exception {
		return false;	}

}
