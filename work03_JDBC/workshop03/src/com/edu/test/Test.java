package com.edu.test;

import java.sql.SQLException;
import java.util.List;

import com.edu.dao.BookDAO;
import com.edu.exception.DMLException;
import com.edu.exception.DuplicateIsbnException;
import com.edu.exception.RecordNotFoundException;
import com.edu.vo.Book;

public class Test {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, DMLException, RecordNotFoundException, DuplicateIsbnException {
		try{
			BookDAO dao = BookDAO.getInstance();
			
			// 1. 정보 입력
			System.out.println("\n============== 신규도서 등록 ==============\n");
			try{
				dao.insertBook(new Book("a1101", "JAVA 기본", "자앤 기술연구소", "자앤 출판사", 23000, "기본"));
				dao.insertBook(new Book("a1102", "JAVA 중급", "자앤 기술연구소", "자앤 출판사", 25000, "중급"));
				dao.insertBook(new Book("a1103", "JAVA 실전", "자앤 기술연구소", "자앤 출판사", 30000, "실전"));
			}catch (DuplicateIsbnException e) {
				System.out.println(e.getMessage());
			}catch (DMLException e) {
				System.out.println(e.getMessage());
			}
			
			// 2. 등록된 모든 리스트 반환
			System.out.println("\n============== 등록된 도서 리스트 ==============\n");
			printAllBooks(dao.listBooks());
			
			// 3. 정보검색(isbn)
			System.out.println("\n============== isbn 검색결과 ==============\n");
			try{
				System.out.println(dao.findBookByIsbn("a1101"));
			}catch (RecordNotFoundException e) {
				System.out.println(e.getMessage());
			}catch (DMLException e) {
				System.out.println(e.getMessage());
			}
			
			// 4. 정보 입력
			System.out.println("\n============== 신규도서 등록 ==============\n");
			try{
				dao.insertBook(new Book("a1104", "JAVA 심화", "자앤 기술연구소", "자앤 출판사", 28000, "심화"));
			}catch (DuplicateIsbnException e) {
				System.out.println(e.getMessage());
			}catch (DMLException e) {
				System.out.println(e.getMessage());
			}
			
			// 5. 정보 수정
			System.out.println("\n============== 등록된 도서정보 수정 ==============\n");
			try {
				dao.updateBook(new Book("a1101", "JAVA 기본", "자앤 기술연구소", "자앤 출판사", 20000, "기본"));	
			}catch(RecordNotFoundException e) {
				System.out.println(e.getMessage());
			}catch (DMLException e) {
				System.out.println(e.getMessage());
			}
				
			printAllBooks(dao.listBooks());
			
			// 6.
			System.out.println("\n============== 등록된 도서정보 삭제 ==============\n");
			try {
				dao.deleteBook("a1104");	
			}catch(RecordNotFoundException e) {
				System.out.println(e.getMessage());
			}catch (DMLException e) {
				System.out.println(e.getMessage());
			}
			
			printAllBooks(dao.listBooks());
			
			// 7. 등록된 도서의 수 검색
			System.out.println("\n============== 등록된 도서의 수 ==============\n");
			System.out.println("[Result OK Message] 등록된 도서는 "+dao.count()+"권 입니다.");
			
			// 8. 통합검색
			System.out.println("\n==============통합검색 결과(제목, 출판사, 작가)==============\n");
			try{
				searchAllBooks(dao.findBookByOthers("중급"));
			}catch (RecordNotFoundException e) {
				System.out.println(e.getMessage());
			}catch (DMLException e) {
				System.out.println(e.getMessage());
			}
			
			// 9. 가격대별 검색
			System.out.println("\n==============가격대별 검색 결과==============\n");
			try{
				searchAllBooks(dao.findBookByPriceRange(25000,26000));
			}catch (RecordNotFoundException e) {
				System.out.println(e.getMessage());
			}catch (DMLException e) {
				System.out.println(e.getMessage());
			}
			
			// 10. 자앤 출판사 도서가격 할인 이벤트 확인
			System.out.println("\n==============할인 이벤트 할인가격 확인==============\n");
			try{
				searchAllBooks(dao.saleBooks("자앤"));
			}catch (RecordNotFoundException e) {
				System.out.println(e.getMessage());
			}catch (DMLException e) {
				System.out.println(e.getMessage());
			}
			
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
	}
		
		private static void printAllBooks(List<Book> list) {
				for (Book book : list) {
					System.out.println(book);
				}
		}	
		
		private static void searchAllBooks(List<Book> list) {
			for (Book book : list) {
				System.out.println(book);
			}
	}
}
	
