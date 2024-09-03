package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.sql.DataSource;

/*
 * Connection 반환하는 방식이
 * DriverManager방식이 아닌 DataSource방식으로 진행...
 * Naming(JNDI) Service가 사용된다.
 * ::
 * 1) DataSource를 먼저 받아온 다음에
 * 2) 1)번 안에 있는 미리 만들어져 있는 Connection을 하나 Rent해 와서 사용할 것이다.
*/
public class MemberDAOImpl implements MemberDAO {
	//추가(*패키지 정확히 알것)
	private DataSource ds;
	
	//싱글톤
	private static MemberDAOImpl dao = new MemberDAOImpl();
	
	private MemberDAOImpl() {
		//Naming Service 작업을 진행
		try {
			InitialContext ic  = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource lookup...Success~~!!");
		}catch(NamingException e) {
			System.out.println("DataSource lookup...Fail~~!!");
		}
	}
	
	public static MemberDAOImpl getInstance() {
		return dao;
	}
	
	
	@Override
	public Connection getConnect() throws SQLException {
		System.out.println("디비 연결 성공...");
		return ds.getConnection();//pool에서 하나씩 꺼내오는 방식..
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps,conn);
	}

	@Override
	public void registerMember(Member vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
		conn = getConnect();
		String query = "INSERT INTO MEMBER (id,password,name,address) VALUES(?,?,?,?);";
		ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPassword());
		ps.setString(3, vo.getName());
		ps.setString(4, vo.getAddress());
		
		System.out.println(ps.executeUpdate()+" 명 등록완료");
				
		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public ArrayList<Member> showAllMember() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Member> list = new ArrayList<Member>();
		
		try {
			conn = getConnect();
			String query = "SELECT id, password, name, address FROM member";
			ps = conn.prepareStatement(query);			
			rs = ps.executeQuery();

			while(rs.next()) {
				list.add(new Member(
					rs.getString("id"), 
					rs.getString("password"),			
					rs.getString("name"), 
					rs.getString("address")));
				}			  
			 
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public Member findByIdMember(String id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member vo = null;
		
		try {
			conn = getConnect();
			String query = "SELECT id, password, name, address FROM member WHERE id=?";
			ps =conn.prepareStatement(query);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new Member(id,
								rs.getString("password"),
								rs.getString("name"),
								rs.getString("address"));
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return vo;
	}
	
	//추후에 가능
	public static void main(String[] args) throws Exception {
		Member rvo = MemberDAOImpl.getInstance().findByIdMember("kosta");//return vo
		System.out.println(rvo);		
	}//main
}//class
