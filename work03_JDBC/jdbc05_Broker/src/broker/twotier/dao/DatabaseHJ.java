package broker.twotier.dao;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.exception.InvalidTransactionException;
import broker.twotier.exception.RecordNotFoundException;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;
import config.ServerInfo;

public class DatabaseHJ implements DatabaseTemplate{
	// 싱글톤
	private static DatabaseHJ db = new DatabaseHJ();
	private DatabaseHJ() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
	}
	public static DatabaseHJ getInstance() {
		return db;
	}
	
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
		System.out.println("디비 연결 성공");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
		
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, conn);
	}
	//존재유무 확인하는 비즈니스 로직..
	private boolean isExist(String ssn, Connection conn) throws SQLException{
		String query = "SELECT ssn FROM customer WHERE ssn=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, ssn);
		
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}
	///////////////////////////////////////비지니스 로직////////////////////////////////////
	@Override
	public void addCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn= getConnect();
			if(!isExist(cust.getSsn(), conn)) {//추가하려는 ssn이 존재하지 않는다면.....
				String query = "INSERT INTO customer (ssn, cust_name, address) VALUES (?,?,?)";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, cust.getSsn());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());
				
				System.out.println(ps.executeUpdate()+"명 Add customer OK");
			}else {
				throw new DuplicateSSNException("고객님은 이미 회원이십니다.");			
			}
		}finally {
			closeAll(ps, conn);
		}	
	}

	@Override
	public void deleteCustomer(String ssn) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn= getConnect();
			
			if(isExist(ssn, conn)) {//ssn이 존재한다면. 
				String query = "DELETE FROM customer WHERE ssn = trim(?)";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, ssn);
				
				System.out.println(ps.executeUpdate()+"명 Delete customer OK");
			}else {
				throw new RecordNotFoundException("가입되지 않은 회원정보입니다.");			
			}
		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void updateCustomer(CustomerRec cust) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn= getConnect();
			
			if(isExist(cust.getSsn(), conn)) {//ssn이 존재한다면. 
				String query = "Update customer SET cust_name = ?, address = ? where ssn = ?";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, cust.getName());
				ps.setString(2, cust.getAddress());
				ps.setString(3, cust.getSsn());
				
				System.out.println(ps.executeUpdate()+"명 update customer OK");
			}else {
				throw new RecordNotFoundException("가입되지 않은 회원정보입니다.");			
			}
		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public ArrayList<SharesRec> getPortfolio(String ssn) throws SQLException {
		ArrayList<SharesRec> sharesList = new ArrayList<SharesRec>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn= getConnect();
			
			if(isExist(ssn, conn)) {//ssn이 존재한다면. 
				String query = "SELECT ssn, symbol, quantity FROM shares WHERE ssn = ?";
				
				ps = conn.prepareStatement(query);
				ps.setString(1, ssn);
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					sharesList.add(new SharesRec(
							rs.getString("ssn"), 
							rs.getString("symbol"),
							rs.getInt("quantity")));
				}if(sharesList.isEmpty()) {
					System.out.println("보유하고 있는 주식이 없습니다.");	
					return null;
				}				
			}else {
				System.out.println("해당하는 회원 정보가 없습니다.");		
				return null;
			}
		}finally {
			closeAll(ps, conn);;
		}
		return sharesList;
	}

	@Override
	public CustomerRec getCustomer(String ssn) throws SQLException {
		CustomerRec cust = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn= getConnect();
			
			if(isExist(ssn, conn)) {//ssn이 존재한다면. 
				String query = "SELECT ssn, cust_name, address FROM custom WHERE ssn = ?";
				
				ps = conn.prepareStatement(query);
				ps.setString(1, ssn);
				
				rs = ps.executeQuery();
				
				if(rs.next()) {
					cust = new CustomerRec(
							rs.getString("ssn"), 
							rs.getString("cust_name"),
							rs.getString("address"));
							cust.setPortfolio(getPortfolio(ssn));

				}if(!cust.getSsn().equals(ssn)) {
					return null;	
				}				
			}else {
				System.out.println("해당하는 회원정보가 없습니다.");	
				return null;
			}
		}finally {
			closeAll(ps, conn);;
		}
		return cust;
	}

	@Override
	public ArrayList<CustomerRec> getAllCustomers() throws SQLException {
		ArrayList<CustomerRec> customerList = new ArrayList<CustomerRec>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn= getConnect();
			
				String query = "SELECT ssn, cust_name, address FROM customer";
				ps = conn.prepareStatement(query);
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					customerList.add(new CustomerRec(
							rs.getString("ssn"), 
							rs.getString("cust_name"),
							rs.getString("address")));
				}if(customerList.isEmpty()) {
					System.out.println("가입되어 있는 회원이 없습니다.");
					return null;
				}					
		}finally {
			closeAll(ps, conn);
		}
		return customerList;
	}

	@Override
	public ArrayList<StockRec> getAllStocks() throws SQLException {
		ArrayList<StockRec> stockList = new ArrayList<StockRec>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn= getConnect();
			
				String query = "SELECT symbol, price FROM stock";
				ps = conn.prepareStatement(query);
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					stockList.add(new StockRec(
							rs.getString("symbol"),
							rs.getFloat("price")));
				}if(stockList.isEmpty()) {
					System.out.println("등록되어 있는 주식이 없습니다.");
				}					
		}finally {
			closeAll(ps, conn);
		}
		return stockList;
	}

	@Override
	public void buyShares(String ssn, String symbol, int quantity) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		SharesRec sharesRec = null;
		
		try {
			conn= getConnect();
			
			if(isExist(ssn, conn)) {//ssn이 존재한다면. 
				if(getPortfolio(ssn)==null) {
					String query = "INSERT INTO shares (ssn, symbol, quantity) VALUES (?,?,?)";
					ps = conn.prepareStatement(query);
					
					ps.setString(1, ssn);
					ps.setString(2, symbol);
					ps.setInt(3, quantity);
					
				System.out.println(ps.executeUpdate()+"건 주식 거래 추가 OK");
				}else {
						String query1 = "SELECT ssn, symbol, quantity from shares where ssn = ? AND symbol=?";
						ps = conn.prepareStatement(query1);
						
						ps.setString(1, ssn);
						ps.setString(2, symbol);

						rs = ps.executeQuery();
						
						while (rs.next()) {
							sharesRec = new SharesRec(
								rs.getString("ssn"),
								rs.getString("symbol"),
								rs.getInt("quantity"));
							
							String query2 = "Update shares SET ssn = ?, symbol = ?, quantity=? where ssn = ?";
							ps = conn.prepareStatement(query2);
							
							ps.setString(1, ssn);
							ps.setString(2, symbol);
							ps.setInt(3, sharesRec.getQuantity()+quantity);
							ps.setString(4, ssn);
							
						System.out.println(ps.executeUpdate()+"건 주식매수 update OK");
						}
					}
			}else {
				System.out.println("가입되지 않은 회원정보입니다.");		
			}
		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void sellShares(String ssn, String symbol, int quantity)
			throws SQLException, InvalidTransactionException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		SharesRec sharesRec = null;
		
		try {
			conn= getConnect();
			
			if(isExist(ssn, conn)) {//ssn이 존재한다면. 
				if(getPortfolio(ssn)==null) {
					System.out.println("보유하고 있는 주식이 없습니다.");
				}else {
					String query1 = "SELECT ssn, symbol, quantity from shares where ssn = ? AND symbol = ?";
					ps = conn.prepareStatement(query1);
					
					ps.setString(1, ssn);
					ps.setString(2, symbol);
	
					rs = ps.executeQuery();
					
					while (rs.next()) {
						sharesRec = new SharesRec(
							rs.getString("ssn"),
							rs.getString("symbol"),
							rs.getInt("quantity"));
						
						String query2 = "Update shares SET ssn = ?, symbol = ?, quantity=? where ssn = ?";
						ps = conn.prepareStatement(query2);
						
						ps.setString(1, ssn);
						ps.setString(2, symbol);
						ps.setInt(3, sharesRec.getQuantity()-quantity);
						ps.setString(4, ssn);
						
						System.out.println(ps.executeUpdate()+"건 주식매도 update OK");
					}
				}
			}else {
				System.out.println("가입되지 않은 회원정보입니다.");		
			}
		}finally {
			closeAll(ps, conn);
		}
	}


	public static void main(String[] args) throws SQLException, RecordNotFoundException {
		db.getInstance();
	
//		try {
//			db.addCustomer(new CustomerRec("111-111", "이희주", "서울"));
//		}catch(Exception e){
//			System.out.println(e.getMessage());
//		}
//		
//		try{
//			db.deleteCustomer("111-111");
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		try {
//			db.updateCustomer(new CustomerRec("111-111", "이희주", "서울"));
//		}catch(Exception e){
//			System.out.println(e.getMessage());
//		}
//		
//		try{
//			printPortfolio(db.getPortfolio("111-112"));
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		try{
//			printAllcustomer(db.getAllCustomers());
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		try{
//			printAllStock(db.getAllStocks());
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		try{
//			db.buyShares("111-111", "DUKE", 54);
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		try{
//			db.sellShares("111-111", "DUKE", 20);
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
//	

	}
	
	public static void printAllcustomer(ArrayList<CustomerRec> list) {
		for (CustomerRec c : list) {
			System.out.println(c);
		}
	}
	
	public static void printAllStock(ArrayList<StockRec> list) {
		for (StockRec st : list) {
			System.out.println(st);
		}
	}

	public static void printPortfolio(ArrayList<SharesRec> list) {
		for (SharesRec sh : list) {
			System.out.println(sh);
		}
	}
}






