package com.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import com.edu.vo.Custom;

import config.ServerInfo;

public class SimpleJDBCTest {
	public SimpleJDBCTest() throws Exception{
		//1. 드라이버 로딩.
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("Driver loading OK");
	}
	
	// 고정적으로 각 메소드마다 반복되는 로직을 공통로직으로 정의....
	public Connection getConnect() throws SQLException {
		Connection conn =DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB 연결 성공");
		return conn;
	}
	
	//열린 순서 반대로 닫아준다.
	public void closeAll(PreparedStatement ps, Connection conn) throws Exception{
		if(ps !=null) ps.close();
		if(conn !=null) conn.close();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws Exception{
		if(rs !=null) rs.close();
		closeAll(ps, conn);
	}
	
	
	public void addCustom(Custom c) throws Exception {
		//insert into.....
		//1. DB 연결
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConnect();
		
		//2. PreparedStatement 생성
		String query = "INSERT INTO custom (id, name, address) VALUE (?,?,?)";
		ps = conn.prepareStatement(query);
		
		//3. 바인딩
		ps.setInt(1, c.getId());
		ps.setString(2, c.getName());
		ps.setString(3, c.getAddress());
		
		//4. 쿼리문 실행
		System.out.println(ps.executeLargeUpdate()+"INSERT Query OK");
		
		//5. 자원반환
		closeAll(ps, conn);
	}
	
	public Custom getCustom(int id) throws Exception {//business logic(중요한 로직..db access하는 로직)
		Custom custom = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//select where
		//insert into.....
		
		//1. DB 연결
		conn =DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB 연결 성공");
		
		//2. PreparedStatement 생성
		String query = "SELECT id, name, address FROM custom WHERE id =?";
		ps = conn.prepareStatement(query);
		
		//3. 바인딩
		ps.setInt(1, id);
		
		//4. 쿼리문 실행
		rs = ps.executeQuery();
		System.out.println("============================================");
		if(rs.next())
			custom = new Custom(id,
								rs.getString("name"),
								rs.getString("address"));
		//5. 자원반환
		closeAll(rs, ps, conn);
		return custom;
	}
		
	public ArrayList<Custom> getCustom() throws Exception {
		ArrayList<Custom> list = new ArrayList<Custom>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//select where
		//insert into.....
		//1. DB 연결
		conn =DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB 연결 성공");
		
		//2. PreparedStatement 생성
		String query = "SELECT id, name, address FROM custom";
		ps = conn.prepareStatement(query);
		
		//4. 쿼리문 실행
		rs = ps.executeQuery();
		System.out.println("============================================");
		while(rs.next()) {
			list.add(new Custom(rs.getInt("id"),
								rs.getString("name"),
								rs.getString("address")));
		}
		//5. 자원반환
		closeAll(rs, ps, conn);
		return list;
	}
	
	public static void main(String[] args) throws Exception{
		
			SimpleJDBCTest dao = new SimpleJDBCTest();
			//dao.addCustom(new Custom(555, "BLAKE", "LA"));
			System.out.println(dao.getCustom(111));	
			
			dao.getCustom().stream()
							.forEach(i->System.out.println(i));
	}
}
