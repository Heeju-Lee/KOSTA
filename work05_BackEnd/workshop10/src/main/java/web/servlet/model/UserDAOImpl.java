package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAOImpl implements UserDAO{
	
	private DataSource ds;  // 데이터 소스 생성. (DB와 통신을 위해)
	
	// 싱글톤
	private static UserDAOImpl dao = new UserDAOImpl();
	private UserDAOImpl() {
		try {
			InitialContext ic = new InitialContext();
			
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");  // 외부 이름 접근법.
			System.out.println("DataSource Lookup Success.");
		} catch (NamingException e) {
			System.out.println("DataSource Lookup Fail.");
		}
	}
	public static UserDAOImpl getInstance() { return dao; }

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("디비연결 성공.");
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null) ps.close();		
		if (conn != null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)	rs.close();
		closeAll(ps, conn);	
	}

	@Override
	public User login(String userId, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User vo = null;
		
		try{
			conn = getConnection();
			
			String query = "SELECT userid, password, name, email FROM userinfo WHERE userid=? and password=?";
			
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement....login()..");
			
			ps.setString(1, userId);
			ps.setString(2, password);
			rs = ps.executeQuery();
			System.out.println("asasasas");
			if(rs.next()) {
				vo = new User(userId, password, rs.getString("name"), rs.getString("email"));
			}
		}finally{
			closeAll(rs, ps, conn);
		}
		return vo;
	}

}
