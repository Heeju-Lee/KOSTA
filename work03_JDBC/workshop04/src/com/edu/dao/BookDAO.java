package com.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.edu.exception.DMLException;
import com.edu.exception.DuplicateIsbnException;
import com.edu.exception.RecordNotFoundException;
import com.edu.vo.Book;

import config.ServerInfo;

public class BookDAO {
	//싱글톤
	private static BookDAO dao = new BookDAO();
	private BookDAO() {}
	public static BookDAO getInstance() throws ClassNotFoundException {
		try{
			Class.forName(ServerInfo.DRIVER_NAME);
			//System.out.println("Driver loading Success!");
		}catch(ClassNotFoundException e){
			System.out.println("Driver loading fail!");
		}
		return dao;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		//System.out.println("DB Connect Success!");
		return conn;
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps !=null) ps.close();
		if(conn !=null) conn.close();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs !=null) rs.close();
		closeAll(ps, conn);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 3.  Book과 Author 테이블을 JOIN하여 도서명, 가격, 저자명을 검색하는 기능을 구현한다. 
	public void findBook(String String) throws DMLException, RecordNotFoundException {
		List<Book> bookList = new ArrayList<Book>();
			
		String query = "SELECT b.isbn isbn, b.title title, b.authorno authorno, a.name authorname, b.publisher publisher, b.price price, b.description description FROM book b JOIN Author a USING(authorno) ON b.title like ? OR b.publisher like ? OR a.name like ? OR b.isbn like ?";
		try(Connection conn = getConnect();
					PreparedStatement ps = conn.prepareStatement(query)){	
				
			ps.setString(1,"%"+String+"%");
			ps.setString(2,"%"+String+"%");
			ps.setString(3,"%"+String+"%");
			ps.setString(4,"%"+String+"%");
				
			ResultSet rs = ps.executeQuery();
				
			while(rs.next()) {
				bookList.add(new Book(
						rs.getString("isbn"),
						rs.getString("title"),
						rs.getString("publisher"),
						rs.getInt("price"),
						rs.getString("description"),
						rs.getInt("authorno"),
						rs.getString("authorname")
						));		
			}
			if(!bookList.isEmpty()) {
				bookList.stream()
					.sorted((a,b)-> a.getAuthorno() -  b.getAuthorno())
					.forEach(i->System.out.println(i));
			}else {
				throw new RecordNotFoundException("[Result Error Message]"+"등록된 정보가 없습니다.");
			}
		}catch(SQLException e) {
			throw new DMLException("[Result Error Message]"+"검색 진행 중 오류가 발생해 처리되지 않았습니다.");
		}
	}
			
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//-- 4. 이름이 ‘ 김XX ’인  저자의 도서명, isbn, 출판사를 출력하는 기능을 작성한다.
	public void findBookByAuthorKim() throws DMLException, RecordNotFoundException {
		List<Book> bookList = new ArrayList<Book>();
			
		String query = "SELECT b.isbn isbn, b.title title, b.authorno authorno, a.name authorname, b.publisher publisher, b.price price, b.description description FROM book b JOIN Author a USING(authorno) ON a.name like '김%'";
		try(Connection conn = getConnect();
				PreparedStatement ps = conn.prepareStatement(query)){	
				
			ResultSet rs = ps.executeQuery();
								
			boolean isExist = false;
			
			while(rs.next()) {
				isExist = true;
				bookList.add(new Book(
						rs.getString("isbn"),
						rs.getString("title"),
						rs.getString("publisher"),
						rs.getInt("price"),
						rs.getString("description"),
						rs.getInt("authorno"),
						rs.getString("authorname")
						));

			}if(!rs.next()) {
				bookList.stream()
				.sorted((a,b)-> a.getAuthorno() -  b.getAuthorno())
				.forEach(i->System.out.println(i.simpleInfo()));
		}else throw new RecordNotFoundException("[Result Error Message]"+"등록된 정보가 없습니다.");
		}catch(SQLException e) {
			throw new DMLException("[Result Error Message]"+"검색 진행 중 오류가 발생해 처리되지 않았습니다.");
		}
	}
		
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//-- 5. Author  테이블에 있는 저자명 별로 출간된 도서들을  도서명, 출판사, 가격, 저자명을 출력하는 기능을 구현한다.
	public void groupAuthor() throws DMLException, RecordNotFoundException {
		List<Book> bookList = new ArrayList<Book>();
		
		String query = "SELECT b.isbn isbn, b.title title, b.authorno authorno, a.name authorname, b.publisher publisher, b.price price, b.description description FROM book b JOIN Author a USING(authorno)";
		try(Connection conn = getConnect();
				PreparedStatement ps = conn.prepareStatement(query)){	
			
			ResultSet rs = ps.executeQuery();
							
			while(rs.next()) {
					bookList.add(new Book(
							rs.getString("isbn"),
							rs.getString("title"),
							rs.getString("publisher"),
							rs.getInt("price"),
							rs.getString("description"),
							rs.getInt("authorno"),
							rs.getString("authorname")
							));
			}if(!bookList.isEmpty()) {
				bookList.stream()
					.sorted((a,b)-> a.getAuthorno() -  b.getAuthorno())
					.forEach(i->System.out.println(i.groupAuthor()));
			}else throw new RecordNotFoundException("[Result Error Message]"+"등록된 정보가 없습니다.");
		}catch(SQLException e) {
			throw new DMLException("[Result Error Message]"+"검색 진행 중 오류가 발생해 처리되지 않았습니다.");
		}
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//-- 6. Book 테이블에 있는 title와 publisher를 이용하여 서로의 관계를 다음과 같이 출력되도록 기능을 구현한다. ( ‘IoT세상은 미래닷컴에서 출판했다’)
	public void relationBook() throws DMLException, RecordNotFoundException {
		List<String> bookList = new ArrayList<String>();
		
		String query = "SELECT concat(b.title,'은(는) ',b.publisher,'에서 출판했다.') relation FROM book b, Author a WHERE b.authorno=a.authorno";
		try(Connection conn = getConnect();
				PreparedStatement ps = conn.prepareStatement(query)){	
			
			ResultSet rs = ps.executeQuery();
							
			while(rs.next()) {
				System.out.println(rs.getString("relation"));
			}
		}catch(NullPointerException e) {
			throw new RecordNotFoundException("[Result Error Message]"+"등록된 정보가 없습니다.");
		}catch(SQLException e) {
			throw new DMLException("[Result Error Message]"+"검색 진행 중 오류가 발생해 처리되지 않았습니다.");
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void insertBook(Book book) throws DuplicateIsbnException, DMLException {
		String query = "INSERT INTO book(isbn, title, authorno, publisher, price, description) VALUES (?,?,?,?,?,?)";
		
		try(Connection conn = getConnect(); 
			PreparedStatement ps = conn.prepareStatement(query)){//finally close 사용안하고 try with 사용
			
			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ps.setInt(3, book.getAuthorno());
			ps.setString(4, book.getPublisher());
			ps.setDouble(5, book.getPrice());
			ps.setString(6, book.getDescription());
		
		
		ps.executeUpdate();
		
		System.out.println("[Result OK Message]"+book.getTitle()+"이(가) 성공적으로 등록되었습니다.");
		}catch(SQLIntegrityConstraintViolationException e) {
			throw new DuplicateIsbnException("[Result Error Message]"+book.getTitle()+"은 이미 등록된 책입니다.");
		}catch(SQLException e) {
			throw new DMLException("[Result Error Message]"+"업데이트 진행 중 오류가 발생해 처리되지 않았습니다.");
		}
	}
	
	public void listBooks() throws SQLException, DMLException, RecordNotFoundException {
		List<Book> bookList = new ArrayList<Book>();
		
		String query = "SELECT b.isbn isbn, b.title title, b.authorno authorno, a.name authorname, b.publisher publisher, b.price price, b.description description FROM book b JOIN Author a USING(authorno)";
		
		try(Connection conn = getConnect();
			PreparedStatement ps = conn.prepareStatement(query)){
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
					bookList.add(new Book(
							rs.getString("isbn"),
							rs.getString("title"),
							rs.getString("publisher"),
							rs.getInt("price"),
							rs.getString("description"),
							rs.getInt("authorno"),
							rs.getString("authorname")
							));
					
			}
			if(!bookList.isEmpty()) {
				for(Book b : bookList) {
					System.out.println(b);
				}

			}else throw new RecordNotFoundException("[Result Error Message]"+"등록된 정보가 없습니다.");
		}catch(SQLException e) {
			throw new DMLException("[Result Error Message]"+"검색 진행 중 오류가 발생해 처리되지 않았습니다.");
		}
	}
}
