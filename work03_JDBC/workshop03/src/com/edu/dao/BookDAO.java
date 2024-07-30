package com.edu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
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
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void insertBook(Book book) throws DuplicateIsbnException, DMLException {
		String query = "INSERT INTO book(isbn, title, author, publisher, price, description) VALUES (?,?,?,?,?,?)";
		
		try(Connection conn = getConnect(); 
				PreparedStatement ps = conn.prepareStatement(query)){//finally close 사용안하고 try with 사용
			
			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getPublisher());
			ps.setDouble(5, book.getPrice());
			ps.setString(6, book.getDescription());	
		
			ps.executeUpdate();
		
			System.out.println("[Result OK Message]"+book.getTitle()+"이 성공적으로 등록되었습니다.");
		}catch(SQLIntegrityConstraintViolationException e) {
			throw new DuplicateIsbnException("[Result Error Message]"+book.getTitle()+"은 이미 등록된 책입니다.");
		}catch(SQLException e) {
			throw new DMLException("[Result Error Message]"+"업데이트 진행 중 오류가 발생해 처리되지 않았습니다.");
		}
	}
	public void updateBook(Book book) throws SQLException, DMLException, RecordNotFoundException {
		String query = "UPDATE book SET title=?, author=?, publisher=?, price=?, description=? WHERE isbn=?";
		try(Connection conn = getConnect(); PreparedStatement ps = conn.prepareStatement(query)){//finally close 사용안하고 try with 사용
			
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getPublisher());
			ps.setInt(4, book.getPrice());
			ps.setString(5, book.getDescription());	
			ps.setString(6, book.getIsbn());
		
			if(ps.executeUpdate()==0) throw new RecordNotFoundException("해당 isbn으로 등록된 정보가 없습니다.");
			else System.out.println(book.getTitle()+"의 정보가 성공적으로 수정되었습니다.");
		}catch(SQLException e) {
			throw new DMLException("업데이트 진행 중 오류가 발생해 처리되지 않았습니다.");
		}
	}
	
	public void deleteBook(String isbn) throws SQLException, DMLException, RecordNotFoundException {

		String query = "DELETE FROM book WHERE isbn=trim(?)";
		
		try(Connection conn = getConnect(); 
				PreparedStatement ps = conn.prepareStatement(query)){
			
			ps.setString(1, isbn);
		
			if(ps.executeUpdate()==0) 
				throw new RecordNotFoundException("[Result Error Message]"+"해당 isbn으로 등록된 정보가 없습니다.");
				System.out.println("[Result OK Message]"+" 정보가 성공적으로 삭제되었습니다.");
		}catch(SQLException e) {
			throw new DMLException("[Result Error Message]"+"삭제 진행 중 오류가 발생해 처리되지 않았습니다.");
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public Book findBookByIsbn(String isbn) throws DMLException, RecordNotFoundException {
		Book book =null;
		
		String query = "SELECT isbn, title, author, publisher, price, description FROM book WHERE isbn=trim(?)";
		
		try(Connection conn = getConnect();
				PreparedStatement ps = conn.prepareStatement(query)){	
			

			ps.setString(1, isbn);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				book = new Book(
						rs.getString("isbn"),
						rs.getString("title"),
						rs.getString("author"),
						rs.getString("publisher"),
						rs.getInt("price"),
						rs.getString("description"));
				
		}else throw new RecordNotFoundException("[Result Error Message]"+"해당 isbn으로 등록된 정보가 없습니다.");

		}catch(SQLException e) {
			throw new DMLException("[Result Error Message]"+"검색 진행 중 오류가 발생해 처리되지 않았습니다.");
		}
		return book;
	}

	public List<Book> findBookByOthers(String String) throws DMLException, RecordNotFoundException {
		List<Book> bookList = new ArrayList<Book>();
		
		String query = "SELECT isbn, title, author, publisher, price, description FROM book WHERE title like ? OR publisher like ? OR author like ?";
		try(Connection conn = getConnect();
				PreparedStatement ps = conn.prepareStatement(query)){	
			
			ps.setString(1,"%"+String+"%");
			ps.setString(2,"%"+String+"%");
			ps.setString(3,"%"+String+"%");
			
			ResultSet rs = ps.executeQuery();
			
			boolean isExist = false;
			
			while(rs.next()) {
				isExist = true;
				bookList.add(new Book(
										rs.getString("isbn"),
										rs.getString("title"),
										rs.getString("author"),
										rs.getString("publisher"),
										rs.getInt("price"),
										rs.getString("description")));

			}
			if(!isExist) 
				throw new RecordNotFoundException("[Result Error Message]"+"해당 검색어로 등록된 정보가 없습니다.");
		}catch(SQLException e) {
			throw new DMLException("[Result Error Message]"+"검색 진행 중 오류가 발생해 처리되지 않았습니다.");
		}
		return bookList;
	}
	
	public List<Book> findBookByPriceRange(int min,int max) throws DMLException, RecordNotFoundException {
		List<Book> bookList = new ArrayList<Book>();
		
		String query = "SELECT isbn, title, author, publisher, price, description FROM book WHERE price BETWEEN ? AND ?";
		try(Connection conn = getConnect();
				PreparedStatement ps = conn.prepareStatement(query)){	
			
			ps.setInt(1, min);
			ps.setInt(2, max);

			ResultSet rs = ps.executeQuery();
			
			boolean isExist = false;
			
			while(rs.next()) {
				isExist = true;
				bookList.add(new Book(
										rs.getString("isbn"),
										rs.getString("title"),
										rs.getString("author"),
										rs.getString("publisher"),
										rs.getInt("price"),
										rs.getString("description")));

			}
			if(!isExist) 
				throw new RecordNotFoundException("[Result Error Message]"+"해당 금액에 해당하는 도서가 없습니다.");
		}catch(SQLException e) {
			throw new DMLException("[Result Error Message]"+"검색 진행 중 오류가 발생해 처리되지 않았습니다.");
		}
		return bookList;
	}
	
	
	public List<Book> listBooks() throws SQLException, DMLException, RecordNotFoundException {
		List<Book> bookList = new ArrayList<Book>();
		
		String query = "SELECT * FROM book";
		
		try(Connection conn = getConnect();
			PreparedStatement ps = conn.prepareStatement(query)){
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
					bookList.add( new Book(rs.getString("isbn"),
											rs.getString("title"),
											rs.getString("author"),
											rs.getString("publisher"),
											rs.getInt("price"),
											rs.getString("description")));
			}
			
		}
		return bookList;
	}
	
	public List<Book> saleBooks(String publisher) throws SQLException, DMLException, RecordNotFoundException {
		List<Book> bookList = new ArrayList<Book>();
		
		String query = "SELECT isbn, title, author, publisher, price*0.8 dicount_price, description FROM book WHERE publisher like ?";//Alias해주기
		try(Connection conn = getConnect();
				PreparedStatement ps = conn.prepareStatement(query)){	
			
			ps.setString(1, "%"+publisher+"%");

			ResultSet rs = ps.executeQuery();
			
			boolean isExist = false;
			
			while(rs.next()) {
				isExist = true;
				bookList.add(new Book(
										rs.getString("isbn"),
										rs.getString("title"),
										rs.getString("author"),
										rs.getString("publisher"),
										rs.getInt("dicount_price"),
										rs.getString("description")));

			}
			if(!isExist) 
				throw new RecordNotFoundException("[Result Error Message]"+"해당 출판사로 등록된 도서가 없습니다.");
		}catch(SQLException e) {
			throw new DMLException("[Result Error Message]"+"검색 진행 중 오류가 발생해 처리되지 않았습니다.");
		}
		return bookList;
	}
	
	//총 도서 개수를 구하는 비지니스 로직.... count().. 행의 수를 리턴하는 그룹함수 -->while ++(X)
	public int count() throws DMLException{
		int totalBooks = 0;
		String query = "SELECT count(isbn) count FROM book";
		try(Connection conn = getConnect();
				PreparedStatement ps = conn.prepareStatement(query)){
			
			ResultSet rs =ps.executeQuery();
			if(rs.next()) totalBooks = rs.getInt("count");//Alias 를 주었기 때문에
		}catch(SQLException e) {
			throw new DMLException("[Result Error Message]"+"도서의 총 갯수를 알기가 힘듭니다.");
		}
		return totalBooks;		
	}
}





//public List<Book> findBookbytitle(String title) throws DMLException, RecordNotFoundException {
//	List<Book> bookList = new ArrayList<Book>();
//	
//	String query = "SELECT isbn, title, author, publisher, price, description FROM book WHERE title like ?";
//	try(Connection conn = getConnect();
//			PreparedStatement ps = conn.prepareStatement(query)){	
//		
//		ps.setString(1,"%"+title+"%");
//		ResultSet rs = ps.executeQuery();
//		
//		boolean isExist = false;
//		
//		while(rs.next()) {
//			isExist = true;
//			bookList.add(new Book(
//									rs.getString("isbn"),
//									rs.getString("title"),
//									rs.getString("author"),
//									rs.getString("publisher"),
//									rs.getInt("price"),
//									rs.getString("description")));
//
//		}
//		if(!isExist) 
//			throw new RecordNotFoundException("[Result Error Message]"+"해당 검색어로 등록된 정보가 없습니다.");
//	}catch(SQLException e) {
//		throw new DMLException("[Result Error Message]"+"검색 진행 중 오류가 발생해 처리되지 않았습니다.");
//	}
//	return bookList;
//}
