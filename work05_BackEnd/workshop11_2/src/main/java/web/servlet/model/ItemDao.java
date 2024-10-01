package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;
import util.DataSourceManager;

public class ItemDao {
	//
	private DataSource ds;
	
	private static ItemDao dao = new ItemDao();
	private ItemDao() {
		//공장을 하나 받아와서...그 안에 있는 Connection을 하나 빌려온다.
		ds = DataSourceManager.getInstance().getConnection();
	}
	public static ItemDao getInstance() {
		return dao;
	}
	
	//공통적인 로직...connection, closeAll()
	public Connection getConnection() throws SQLException {
		System.out.println("디비연결 성공...");
		return ds.getConnection();
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps!=null) ps.close();		
		if(conn != null) conn.close();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{		
		if(rs != null)	rs.close();
		closeAll(ps, conn);		
	}
	
	//가변적인 로직...
	public ArrayList<Item> getAllItem() throws SQLException{
		ArrayList<Item> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "SELECT * FROM item";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Item(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getInt(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getInt(6)));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return list;
	}
	
	public Item getItem(int itemnum) throws SQLException {
		Item item = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "SELECT * FROM item WHERE item_id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, itemnum);
			rs = ps.executeQuery();
			if(rs.next()) {
				item = new Item(
						itemnum, 
						rs.getString(2), 
						rs.getInt(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getInt(6));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return item;
	}
	
	public boolean updateRecordCount(int itemid) throws SQLException {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "UPDATE item SET count=count+1 WHERE item_id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, itemid);
			int row = ps.executeUpdate(); //0,1
			if(row>0) result = true;
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return result;
	}
	/*public void updateCount(int count, int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
			String query = "UPDATE item SET count=? WHERE item_id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, count);
			ps.setInt(2, id);
			ps.executeUpdate();
		} finally {
			closeAll(ps, conn);
		}
	}*/
	
}