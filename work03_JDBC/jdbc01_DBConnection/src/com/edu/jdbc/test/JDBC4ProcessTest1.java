package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/*
  [JDBC 기본 4단계 작업]
  1. 서버정보를 담고 있는 드라이버 로딩
  2. 디비서버 연결.....성공하면 Connection 객체가 만들어지고 클라이언트에게 connection객체 반환됨.
  3. PreparedStatement 객체 생성(Query를 실행하는 함수를 가지고 있음)
  4. SQL 쿼리문 실행
 */
public class JDBC4ProcessTest1 {
	public JDBC4ProcessTest1() {
		try {
			//1. 드라이버 로딩
			//forName에 예외처리가 포함돼있어서 try catch 써야함.
			//mysql-connector-java-8.0.32.jar download
			Class.forName("com.mysql.cj.jdbc.Driver");//드라이버의 실제 이름을 넣어준다.(FQCN: 패키지명을 포함한 이름)
			System.out.println("Driver Loading Success....");
			
			//2. connection 인자값 : mySQL url, id, pw
			String url = 
					"jdbc:mysql://127.0.0.1:3306/kosta?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
			Connection conn =DriverManager.getConnection(url, "root", "1234");
			System.out.println("DB Connection Success....");
			
			//3. PreparedStatement 객체 생성
			//여기서 쿼리가 실행되는건 아님 컴파일만 된다. ps. excuteUpdate(); 에서 쿼리가 실행되고 DB에 입력됨.
			String query = "INSERT INTO custom (id, name, address) VALUES(?,?,?)";
			PreparedStatement ps =conn.prepareStatement(query);
			System.out.println("PreparedStatement Creating....");
			
			//4. 1) ?에 값을 바인딩 2) sql 실행... 이때 데이터가 입력될 것임.
			
			ps.setInt(1,111);
			ps.setString(2, "JAMES");
			ps.setString(3, "PARIS");
			
			int row = ps.executeUpdate();
			System.out.println(row+" ROW Record 등록 성공");
			
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Loading Fail....");
		}catch(SQLException e) {
			System.out.println("DB Connection Fail....");
		}
	}
	
	public static void main(String[] args) {
		new JDBC4ProcessTest1();
	}

}
