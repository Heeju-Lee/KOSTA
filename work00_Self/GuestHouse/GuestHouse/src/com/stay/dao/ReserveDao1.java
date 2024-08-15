package com.stay.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.stay.exception.DMLException;
import com.stay.exception.DuplicateIDException;
import com.stay.exception.RecordNotFoundException;
import com.stay.vo.Customer;
import com.stay.vo.Reservation;
import com.stay.vo.Room;

import config.ServerInfo;
import com.stay.vo.GuestHouse;

public class ReserveDao1 {

	//싱글톤
	private static ReserveDao1 dao = new ReserveDao1();

	private ReserveDao1() {
		//driver 로딩
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading 실패");
		}
		
	}
	
	public static ReserveDao1 getInstance() {
		return dao;
	}
	
	public Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		//System.out.println("DB Connection 성공");
		return conn;
	}
	
	public void create(Customer cust) throws DMLException, DuplicateIDException {
		String query = "INSERT INTO customer(id, name, pass, phone) VALUES(?,?,?,?)";
		
		try(Connection conn = getConnection(); 
			PreparedStatement ps = conn.prepareStatement(query)) {
				
			ps.setString(1, cust.getId());
			ps.setString(2, cust.getName());
			ps.setString(3, cust.getPass());
			ps.setString(4, cust.getPhone());

			ps.executeUpdate();

			System.out.println("회원 가입에 성공하셨습니다.");
			
		}catch (SQLIntegrityConstraintViolationException e) { 
			throw new DuplicateIDException("[ERROR] 이미 회원가입된 상태입니다. 다시 확인해주세요");
			
		}catch (SQLException e) {
			throw new DMLException("[ERROR] 회원 가입 시 문제가 발생해 가입이 이뤄지지 않았습니다.");
		}
	}
	
	public String login( String id, String pass) throws RecordNotFoundException, DMLException {
		
		String query = "SELECT id, pass FROM customer WHERE id =? and pass =?";

		try (Connection conn = getConnection();
			 PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setString(1, id);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			
			if( !rs.next()) {
				throw new RecordNotFoundException("[ERROR] 존재하지 않는 회원입니다.");
			}
			else System.out.println("로그인에 성공하셨습니다.");

		} catch (SQLException e) {
			throw new DMLException("[ERROR] 로그인 시 문제가 발생해 로그인이 이뤄지지 않았습니다.");
		}
		
		return id;
	}
	
	
	public void update(Customer cust) throws RecordNotFoundException, DMLException {
		
		String query = "UPDATE customer SET pass = ?, phone = ? where id = ?";
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(query)) {
			
			ps.setString(1, cust.getPass());
			ps.setString(2, cust.getPhone());
			ps.setString(3, cust.getId());
			
			if(ps.executeUpdate() == 0) {
				throw new RecordNotFoundException("[ERROR] 존재하지 않는 id 입니다.");
			}
			else System.out.println("회원정보 수정에 성공하셨습니다.");

		} catch (SQLException e) {
			throw new DMLException("[ERROR] 회원 정보 수정 시 문제가 발생해 수정이 이뤄지지 않았습니다.");
		}
	}
	
	
	public void delete(String id) throws RecordNotFoundException, DMLException  {
		
		String query = "delete from customer where id =?";
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(query);) {
			
			ps.setString(1, id);
			
			if(ps.executeUpdate() ==0) {
				throw new RecordNotFoundException("[ERROR] 존재하지 않는 id 입니다.");
			}
			else System.out.println("회원 탈퇴에 성공했습니다.");

		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			//throw new DMLException("[ERROR] 회원 삭제 시 문제가 발생해 삭제가 이뤄지지 않았습니다.");
		}
	}
	

	public ArrayList<GuestHouse> findByReviewCount(String location) throws DMLException{
		ArrayList<GuestHouse> list= new ArrayList<>();
		ResultSet rs=null;
		String query="SELECT g1.id,g1.name,g1.address,g1.room_num,g1.room_price,g1.capacity,"
				+ "(select count(r.content) from review r join guesthouse g2 "
				+ "where r.GuestHouse_id=g2.id AND r.GuestHouse_id=g1.id) 리뷰수 "
				+ "from guesthouse g1  WHERE  g1.address=? ORDER BY 7 desc;";
		try(
			Connection conn=getConnection();
			PreparedStatement ps = conn.prepareStatement(query)){
			ps.setString(1, location);
			
			rs=ps.executeQuery();
			int i=0;
			String tid=null;
			if(rs.next()) {
				tid=rs.getString(1);
				list.add(new GuestHouse());
				list.get(i).setId(rs.getString(1));
				list.get(i).setName(rs.getString(2));
				list.get(i).setAddress(rs.getString(3));
				list.get(i++).getRooms().add(new Room(rs.getInt("room_num"),rs.getInt("room_price"),rs.getInt("capacity")));
			}else throw new RecordNotFoundException("[ERROR] 게스트 하우스가 존재하지 않습니다.");

			while(rs.next()) {
				if(!rs.getString(1).equals(tid)) {
					tid=rs.getString(1);
					list.add(new GuestHouse());
					list.get(i).setId(rs.getString(1));
					list.get(i).setName(rs.getString(2));
					list.get(i).setAddress(rs.getString(3));
					
				}else {
					i=i-1;
					
				}list.get(i++).getRooms().add(new Room(rs.getInt(4),rs.getInt(5),rs.getInt(6)));
			}
			
		}catch(SQLException s) {
			throw new DMLException("[ERROR] 검색 도중 문제가 발생했습니다.");
		}
		return list;
	}

	//1. 방마다 가격인하율 뽑아서 방 30개 리스트 출력
	public ArrayList<GuestHouse> findByLeadMonth(String location) throws DMLException{
		ArrayList<GuestHouse> list= new ArrayList<>();
		ResultSet rs=null;
		String query="SELECT g1.id,g1.name, g1.address, g1.room_num, g1.room_price, g1.capacity,(g2.room_price - g1.room_price )/g2.room_price*100 인하율 "
				+ "FROM guesthouse g1 , JulyGuesthouse g2 "
				+ "WHERE g1.room_num=g2.room_num AND g1.id=g2.id  AND g1.address= ? "
				+ "ORDER BY 인하율 desc;";
		try(
			Connection conn=getConnection();
			PreparedStatement ps = conn.prepareStatement(query);){
			ps.setString(1, location);

			rs=ps.executeQuery();
			int i=0;
			while(rs.next()) {
				list.add(new  GuestHouse(rs.getString(1),rs.getString(2),rs.getString(3),new ArrayList<Room>()));
				list.get(i++).getRooms().add(new Room(rs.getInt(4),rs.getInt(5),rs.getInt(6)));
			}
			
		}catch (SQLException e) {
			throw new DMLException("[ERROR] 검색 도중 문제가 발생했습니다.");
		}

		return list;
	}
	
	
	//2. 숙소마다 가격인하율 평균을 내서 숙소 10개 리스트만 출력
	public ArrayList<GuestHouse> findByLeadMonth2(String location) throws DMLException{
		ArrayList<GuestHouse> list= new ArrayList<>();
		ResultSet rs=null;
		String query="SELECT DISTINCT g4.id,g4.name,g4.address,g5.인하율평균\r\n"
				+ "from guesthouse g4, \r\n"
				+ "(SELECT g3.id,avg(g3.인하율) 인하율평균\r\n"
				+ "from (SELECT g1.id,(g2.room_price - g1.room_price )/g2.room_price*100 인하율\r\n"
				+ "FROM guesthouse g1 , JulyGuesthouse g2\r\n"
				+ "WHERE g1.room_num=g2.room_num AND g1.id=g2.id  AND g1.address= ?"
				+ ") g3\r\n"
				+ "GROUP BY id) g5\r\n"
				+ "where g4.id=g5.id\r\n"
				+ "ORDER BY 4 desc;";
		
		try(
			Connection conn=getConnection();
			PreparedStatement ps = conn.prepareStatement(query);){
			ps.setString(1, location);

			rs=ps.executeQuery();
			int i=0;
			while(rs.next()) {
				list.add(new  GuestHouse(rs.getString(1),rs.getString(1),rs.getString(1),null));

			}
			
		}catch (SQLException e) {
			throw new DMLException("[ERROR] 검색 도중 문제가 발생했습니다.");
		}
        return list;
    }

	// 지역 내 게스트하우스 숙소별 최저가 sorting
	public 	ArrayList<GuestHouse> findByMinPrice(String location) throws DMLException {
		ArrayList<GuestHouse> list =  new ArrayList<>();

		String query = "SELECT g1.id, g1.name, g1.address, g1.room_num, g1.room_price, g1.capacity " +
						"FROM guesthouse g1 " +
						"JOIN (SELECT name, MIN(room_price) AS min_price FROM guesthouse WHERE address = ? GROUP BY name) g2 " +
						"ON g1.name = g2.name AND g1.room_price = g2.min_price WHERE g1.address = ? ORDER BY g1.room_price";

		try (Connection con = getConnection();
			 PreparedStatement ps = con.prepareStatement(query)) {

			ps.setString(1, location);
			ps.setString(2, location);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ArrayList<Room> rooms = new ArrayList<>();
				rooms.add(new Room(
						rs.getInt("room_num"),
						rs.getInt("room_price"),
						rs.getInt("capacity")));
				list.add(new GuestHouse(
						rs.getString("id"),
						rs.getString("name"),
						rs.getString("address"),
						rooms));
				}
			return list;
			}
		
			catch (SQLException e) {
			throw new DMLException("[ERROR] 검색 도중 문제가 발생했습니다.");
		}
	}

	// 지역 내 게스트하우스별 평점 상위 10% 숙소 sorting
	public 	ArrayList<GuestHouse> findByTopTenPercent(String location) throws DMLException {
		ArrayList<GuestHouse> list =  new ArrayList<>();
		Set<String> guestHouseIds = new HashSet<>();

		String query = "SELECT s.id, s.name, s.address, s.room_num, s.room_price, s.capacity, s.percent " +
						"FROM(SELECT g1.id, g1.name, g1.address, g1.room_num, g1.room_price, g1.capacity, g2.avg_rating, " +
							"percent_rank()over(partition by address order by avg_rating desc) AS percent " +
							"FROM guesthouse g1 " +
							"JOIN (SELECT guesthouse_id, avg(rating) avg_rating FROM review GROUP BY GuestHouse_id) g2 " +
							"ON g1.id=g2.guesthouse_id WHERE g1.address = ?) s " +
						"WHERE s.percent<=0.1";

		try (Connection con = getConnection();
			 PreparedStatement ps = con.prepareStatement(query)) {

			ps.setString(1, location);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				if (guestHouseIds.add(id)) {
					list.add(new GuestHouse(
						rs.getString("id"),
						rs.getString("name"),
						rs.getString("address")));
				}
			}
			return list;
		}
		catch (SQLException e) {
			throw new DMLException("[ERROR] 검색 도중 문제가 발생했습니다.");
		}
	}

	
	// 가격 범위로 게스트 하우스 조회
	public 	ArrayList<GuestHouse> findByPrice(String location, int x, int y) throws DMLException {
		ArrayList<GuestHouse> list =  new ArrayList<>();

		String query = "SELECT id, name, address, room_num, room_price, capacity " +
						"FROM guesthouse " +
						"WHERE address = ? AND room_price between ? AND ?";

		try (Connection con = getConnection();
			 PreparedStatement ps = con.prepareStatement(query)) {

			ps.setString(1, location);
			ps.setInt(2, x);
			ps.setInt(3, y);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ArrayList<Room> rooms = new ArrayList<>();
				rooms.add(new Room(
						rs.getInt("room_num"),
						rs.getInt("room_price"),
						rs.getInt("capacity")));
				list.add(new GuestHouse(
						rs.getString("id"),
						rs.getString("name"),
						rs.getString("address"),
						rooms));
				}
				if(list.isEmpty()){
				System.out.println("검색하신 가격 범위의 게스트하우스는 없습니다.");
			}
			return list;
		} catch (SQLException e) {
			throw new DMLException("[ERROR] 검색 도중 문제가 발생했습니다.");
		}
	}

	
	
	public List<GuestHouse> findByReservable(String location, String startdate, String enddate) {
		String query1="SELECT * FROM guesthouse where address =?";
		String query2="SELECT GuestHouse_id,GuestHouse_room_num FROM reservation WHERE start_date= ? or end_date= ? or (? < start_date AND ? > start_date) or ( ? < end_date and ? > end_date)";
		
		ResultSet rs1=null;
		ResultSet rs2=null;
		List<GuestHouse> list= new ArrayList<>();
		int i=0;
		try(
			Connection conn=getConnection();
			PreparedStatement ps1 = conn.prepareStatement(query1);
			PreparedStatement ps2 = conn.prepareStatement(query2);){
			
			ps1.setString(1, location);
			ps2.setString(1, startdate);
			ps2.setString(2, enddate);
			ps2.setString(3, startdate);
			ps2.setString(4, enddate);
			ps2.setString(5, startdate);
			ps2.setString(6, enddate);
			
			rs1=ps1.executeQuery();
			while(rs1.next()) {
			list.add(new GuestHouse(rs1.getString(1),rs1.getString(2) ,rs1.getString(3)));
			list.get(i++).getRooms().add(new Room(rs1.getInt(4),rs1.getInt(5),rs1.getInt(6)));
			}
			
			rs2=ps2.executeQuery();
			while(rs2.next()){
				for(GuestHouse g : list) {
					if( g.getId().equals(rs2.getString(1))& g.getRooms().get(0).getNum()==rs2.getInt(2)) {
						list.remove(g);
					}
				}
			}
			
		}catch (SQLException e) {
			throw new DMLException("[ERROR] 검색 도중 문제가 발생했습니다. ");
		}catch (ConcurrentModificationException e) {
			
		}
		
		return list;
	}
	
	public void reservation (String startDate, String endDate, String house_id, int room_num, String customId) {
		String query1 = "insert into reservation( start_date, end_date, total_price, Customer_id, GuestHouse_id, GuestHouse_room_num) values(?,?,?,?,?,?);";
		String query2 = "select room_price from guesthouse where id= ? and room_num = ?;";

		LocalDate stdate = LocalDate.parse(startDate);
		LocalDate endate = LocalDate.parse(endDate);
		
		int roomPrice = 0;
		Period diff = Period.between(stdate, endate);
		int diffdate = diff.getDays();
		//System.out.println("날짜 차이는 "+diffdate);
		
		try (Connection conn = getConnection();
			 PreparedStatement ps2 = conn.prepareStatement(query2);
			 PreparedStatement ps1 = conn.prepareStatement(query1)) {

			ps2.setString(1, house_id);
			ps2.setInt(2, room_num);

			ResultSet rs = ps2.executeQuery();

				if (rs.next()) {
					//1박당 가격
					roomPrice = rs.getInt("room_price");
					//총가격
					roomPrice = roomPrice * diffdate;
				}

				if (isdate(stdate, endate,room_num,house_id)) {
					ps1.setString(1, startDate);
					ps1.setString(2, endDate);
					ps1.setInt(3, roomPrice);
					ps1.setString(4, customId);
					ps1.setString(5, house_id);
					ps1.setInt(6, room_num);
					ps1.executeUpdate();
					System.out.println("예약에 성공하셨습니다.");
				}
				else System.out.println("해당 날짜는 이미 예약되었습니다.");

		} catch (SQLException e) {
        throw new DMLException("예약 진행 시 문제가 발생해서 예약을 중단합니다.");
		}
	}

		public  boolean isdate(LocalDate startdate, LocalDate enddate,int roomnum, String house_id){
			String query = "select start_date,end_date, GuestHouse_id, GuestHouse_room_num from reservation WHERE GuestHouse_id =? and GuestHouse_room_num =? ;";

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			boolean flag = true;

			List<LocalDate[]> datePairs = new ArrayList<>();
			try(Connection conn = getConnection();  
				PreparedStatement ps = conn.prepareStatement(query)) {

				ps.setString(1,house_id);
				ps.setInt(2,roomnum);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()){
					LocalDate startDate = LocalDate.parse(rs.getString("start_date"), formatter);
					LocalDate endDate = LocalDate.parse(rs.getString("end_date"), formatter);
					datePairs.add(new LocalDate[]{startDate, endDate});
				}
				
				for (LocalDate[] datePair : datePairs) {
					
					LocalDate s = datePair[0];
					LocalDate e = datePair[1];
					
					if (startdate.equals(s) || enddate.equals(e) ) flag = false; 
					else if(startdate.isAfter(s) && enddate.isBefore(e) ) flag = false; // 모두 속하지 않을 때,
					else if(startdate.isBefore(s)  && enddate.isAfter(e) )flag = false; // 전 범위에 속할 때,
					
					else if(startdate.isBefore(s) && enddate.isAfter(s) && enddate.isBefore(e) ) flag= false;	
					else if(startdate.isAfter(s) && startdate.isBefore(e) && enddate.isAfter(e) ) flag = false;
					else break;
					
				}
			}catch (SQLException e){

			}
			return flag;
		}


	
	
	// 내가 예약한 정보 조회
	public  ArrayList<Reservation> findMyReservation(String id) throws DMLException {
		ArrayList<Reservation> list =  new ArrayList<>();

		String query = "SELECT id, start_date, end_date, total_price, Customer_id, GuestHouse_id, GuestHouse_room_num FROM reservation WHERE Customer_id = ?";

		try (Connection con = getConnection();
			 PreparedStatement ps = con.prepareStatement(query)) {

			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Reservation(
						rs.getString("GuestHouse_id"),
						rs.getString("GuestHouse_room_num"),
						rs.getDate("start_date"),
						rs.getDate("end_date"),
						rs.getInt("total_price")
				));
			}
			
			if(list.isEmpty()){
				System.out.println("예약하신 내용이 존재하지 않습니다.");
			}
			
			return list;
		} catch (SQLException e) {
			throw new DMLException("[ERROR] 검색 도중 문제가 발생했습니다.");
		}
	}
	
	
	public void cancelReservation(String houseid, int room_num, String cust_id, String start_date, String end_date ) throws DMLException, RecordNotFoundException{

		String query="  DELETE FROM reservation "
				+ "WHERE customer_id=? AND Guesthouse_id=? AND Guesthouse_room_num=? "
				+ "AND start_date=? AND end_date=?; ";

		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate startdate= LocalDate.parse(start_date, formater);
		LocalDate enddate= LocalDate.parse(end_date, formater);


		if(!isdate(startdate, enddate, room_num, houseid)) {
			
			try(Connection conn=getConnection();
				PreparedStatement ps = conn.prepareStatement(query);){
				
				ps.setString(1, cust_id);
				ps.setString(2, houseid);
				ps.setInt(3, room_num);
				ps.setString(4, start_date);
				ps.setString(5, end_date);

				ps.executeUpdate();
				
				System.out.println("예약이 취소됐습니다.");
				
			}catch (SQLException e) {
				throw new DMLException("예약 취소 중 문제가 발생해서 예약을 중단합니다.");
			}
		}else throw new RecordNotFoundException("[ERROR] 해당하는 예약건이 존재하지 않습니다.");

	}
	
	
}//class
