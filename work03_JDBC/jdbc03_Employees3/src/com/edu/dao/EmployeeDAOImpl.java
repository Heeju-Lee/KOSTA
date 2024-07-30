package com.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import com.edu.exception.DuplicateNumException;
import com.edu.vo.Employee;

import config.ServerInfo;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	// 싱글톤 생성
	private static EmployeeDAOImpl empDAO = new EmployeeDAOImpl();
	private EmployeeDAOImpl() {}
	public static EmployeeDAOImpl getInstance() throws ClassNotFoundException {
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("Driver loading Success!");

		return empDAO;
	}
//////////////////////////////////////공통적인 로직 //////////////////////////////////////////////
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
		System.out.println("DB Connect Success!");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps !=null) ps.close();
		if(conn !=null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs != null) rs.close();
		closeAll(ps, conn);		
	}
////////////////////////////////////// 비지니스 로직 //////////////////////////////////////////////
//isExist를 사용하지 않는 경우....쿼리문을 두번 돌릴 필요가 없다.(select가 안돌아간다.)
	@Override
	//해당코드의 문제점
	//1. connection 연결, 반환 X, 중간에 error가 나면 close가 안된다....finally로 무조건 동작해야 함.
	//2. 존재유무 확인이 없음.(ADD, REMOVE, UPDATE)
	public void insertEmployee(Employee emp) {

		String query = "INSERT INTO employee (num, name, salary, address) VALUES (?,?,?)";
		try (Connection conn = getConnect();
				PreparedStatement ps = conn.prepareStatement(query)){ // 더 안정적

				ps.setInt(1, emp.getNum());
				ps.setString(2, emp.getName());
				ps.setDouble(3, emp.getSalary());
				ps.setString(4, emp.getAddress());
				
				System.out.println(ps.executeUpdate()+" Row Insert Success!");
		
		}catch(SQLIntegrityConstraintViolationException e){    //PK 중복오류
			System.out.println(e.getMessage());
		}catch(SQLException e) {    //SQL문법오류
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void removeEmployee(int num) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnect();

		String query = "DELETE FROM employee WHERE num=?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, num);
		
		System.out.println(ps.executeUpdate()+" Row Delete Success!");
		closeAll(ps, conn);
	}

	@Override
	public void updateEmployee(Employee emp, int num) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnect();

		String query = "UPDATE employee SET name =?, salary=?, address=? WHERE num=?";
		ps = conn.prepareStatement(query);
		
		ps.setString(1, emp.getName());
		ps.setDouble(2, emp.getSalary());
		ps.setString(3, emp.getAddress());
		ps.setInt(4, num);
		
		System.out.println(ps.executeUpdate()+" Row Update Success!");
		closeAll(ps, conn);
	}

	@Override
	public ArrayList<Employee> selectEmployee() throws Exception {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnect();
		
		System.out.println("\n======================== 전체검색결과 ========================\n");
		ArrayList<Employee> list = new ArrayList<Employee>();		
		
		String query = "SELECT num, name, salary, address FROM employee";
		ps = conn.prepareStatement(query);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			list.add(new Employee(
					rs.getInt("num"),
					rs.getString("name"),
					rs.getDouble("salary"),
					rs.getString("address")));
		}
	
		list.stream()
			.forEach(i->System.out.println(i));		
		System.out.println("\n===========================================================\n");
		
		closeAll(rs, ps, conn);
		return list;
	}

	@Override
	public Employee selectEmployee(int num) throws Exception{


		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee employee = null;
		conn = getConnect();
		
		System.out.println("\n=================== num :"+num+"번 검색결과 ===================\n");
		String query = "SELECT num, name, salary, address FROM employee WHERE num=?";
		ps = conn.prepareStatement(query);
		
		ps.setInt(1, num);
			
		rs = ps.executeQuery();
				
		if(rs.next()) {
			employee = new Employee(
					rs.getInt("num"),
					rs.getString("name"),
					rs.getDouble("salary"),
					rs.getString("address")
			);
			System.out.println(employee);
			System.out.println("\n=========================================================\n");
		}
		closeAll(rs, ps, conn);
		return employee;
	}

}
