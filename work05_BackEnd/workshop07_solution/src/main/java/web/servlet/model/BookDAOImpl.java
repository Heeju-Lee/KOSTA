package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BookDAOImpl implements BookDAO{

	private DataSource ds;  // 데이터 소스 생성. (DB와 통신을 위해)
	
	// 싱글톤
	private static BookDAOImpl dao = new BookDAOImpl();
	private BookDAOImpl() {
		try {
			InitialContext ic = new InitialContext();
			
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");  // 외부 이름 접근법.
			System.out.println("DataSource Lookup Success.");
		} catch (NamingException e) {
			System.out.println("DataSource Lookup Fail.");
		}
	}
	public static BookDAOImpl getInstance() { return dao; }
	
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
	public void registerBook(Book vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = getConnection();
			String query = "INSERT INTO book VALUES(?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement 생성됨.");
			
			ps.setString(1, vo.getIsbn());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getCatalogue());
			ps.setString(4, vo.getNation());
			ps.setString(5, vo.getPublish_date());
			ps.setString(6, vo.getPublisher());
			ps.setString(7, vo.getAuthor());
			ps.setInt(8, vo.getPrice());
			ps.setString(9, vo.getCurrency());
			ps.setString(10, vo.getDescription());
			
			System.out.println(ps.executeUpdate()+" row INSERT OK!!");
		}finally{
			closeAll(ps, conn);
		}
		
	}
	
	public ArrayList<Book> showAllBook() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Book> list = new ArrayList<>();
		try {
			conn = getConnection();
			String query = "SELECT isbn, title, catalogue, nation, publish_date, publisher, author, price, currency, description FROM book";
			ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement.");
			
			rs = ps.executeQuery();
			while(rs.next()) {
				Book b = new Book(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getInt(8), rs.getString(10));
				b.setCurrency(rs.getString(9));
				list.add(b);
			}
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public ArrayList<Book> findBookList(String searchSelect, String searchText) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Book> list = new ArrayList<>();
		
		try {
			conn = getConnection();
			
			String query = "SELECT * FROM book WHERE " + searchSelect + " LIKE ?";
			System.out.println(query);
			
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + searchText + "%");
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("catalogue"), rs.getString("nation"), 
						rs.getString("publish_date"), rs.getString("publisher"), rs.getString("author"), rs.getInt("price"), 
						rs.getString("description")));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}

}
