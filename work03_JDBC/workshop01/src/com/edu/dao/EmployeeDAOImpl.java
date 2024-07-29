package com.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	
	//메인 메소드
	public static void main(String[] args) throws Exception {
		EmployeeDAOImpl empDAO = EmployeeDAOImpl.getInstance();
		//3명삽입
//		empDAO.insertEmployee(new Employee(111,"JAMES", 1234.5,"LA"));
//		empDAO.insertEmployee(new Employee(222,"TOMAS", 1550.4,"NY"));
//		empDAO.insertEmployee(new Employee(333,"JULIET", 1487.1,"LA"));
		
		//전체검색
		empDAO.selectEmployee();
		
		//num검색
		empDAO.selectEmployee(111);
		
		//DELETE
		empDAO.removeEmployee(222);
		empDAO.selectEmployee();//삭제되었는지 확인
		
		//수정
		empDAO.updateEmployee(new Employee("SCOTT", 1567.2, "NY"),111);
	
		
	}

	@Override
	public Connection getConnect() throws Exception {
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
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws Exception {
		if(rs != null) rs.close();
		closeAll(ps, conn);		
	}

	@Override
	public void insertEmployee(Employee emp) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnect();

		String query = "INSERT INTO employee (num, name, salary, address) VALUE (?,?,?,?)";
		ps = conn.prepareStatement(query);
		
		ps.setInt(1, emp.getNum());
		ps.setString(2, emp.getName());
		ps.setDouble(3, emp.getSalary());
		ps.setString(4, emp.getAddress());
		
		System.out.println(ps.executeUpdate()+" Row Insert Success!");
		closeAll(ps, conn);
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
		
		System.out.println("================= 전체검색결과 =================");
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
		System.out.println("=============================================");
		
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
		
		System.out.println("================= num "+num+"번 검색결과 =================");
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
			System.out.println("====================================================");
		}
		closeAll(rs, ps, conn);
		return employee;
	}

}
