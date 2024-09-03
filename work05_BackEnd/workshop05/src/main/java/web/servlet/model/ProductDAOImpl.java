package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductDAOImpl implements ProductDAO{
	//datasource 연결
	public DataSource ds;
	
	//싱글톤
	private static ProductDAOImpl dao = new ProductDAOImpl();
	private ProductDAOImpl() {
		try {
			InitialContext ic  = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource lookup...Success~~!!");
		}catch(NamingException e) {
			System.out.println("DataSource lookup...Fail~~!!");
		}
	}
	public static ProductDAOImpl getInstance() {
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
	public void registerProduct(Product vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			String query = "INSERT INTO product (name,price,pdesc) VALUES(?,?,?);";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, vo.getName());
			ps.setInt(2, vo.getPrice());
			ps.setString(3, vo.getDesc());
			
			System.out.println(ps.executeUpdate()+"개 등록완료");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			closeAll(ps, conn);
		}

	}

	@Override
	public ArrayList<Product> findProducts() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<Product> list = new ArrayList<Product>();
		
		try {
			conn = getConnect();
			String query = "SELECT productNum, name, price, pdesc FROM product;";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Product(
							rs.getInt("productNum"),
							rs.getString("name"),
							rs.getInt("price"),
							rs.getString("pdesc")
						));
			}	
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
}

