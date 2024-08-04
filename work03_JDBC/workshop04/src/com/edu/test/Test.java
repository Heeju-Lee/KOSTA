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
//				dao.insertBook(new Book("a1101", "JAVA 기본", "자앤 출판사", 23000, "기본",100));
//				dao.insertBook(new Book("a1102", "JAVA 중급", "자앤 출판사", 25000, "중급",200));
//				dao.insertBook(new Book("a1103", "JAVA 실전", "자앤 출판사", 30000, "실전",300));
//				dao.insertBook(new Book("a1104", "이것이MYSQL이다", "한빛미디어", 27000, "실전",600));
				dao.insertBook(new Book("a1105", "이것이 자바다", "한빛미디어", 24500, "실전",600));
			}catch (DuplicateIsbnException e) {
				System.out.println(e.getMessage());
			}catch (DMLException e) {
				System.out.println(e.getMessage());
			}
			
			// 2. 등록된 모든 리스트 반환
			System.out.println("\n============== 등록된 도서 리스트 ==============\n");
			try{
				dao.listBooks();
			}catch (DMLException e) {
				System.out.println(e.getMessage());
			}
			
			// 3.  Book과 Author 테이블을 JOIN하여 도서명, 가격, 저자명을 검색하는 기능을 구현한다. 
			System.out.println("\n==============통합검색 결과(isbn, 제목, 출판사, 작가명)==============\n");
			try{
				dao.findBook("중급");
			}catch (RecordNotFoundException | DMLException e) {
				System.out.println(e.getMessage());
			}

			// 4. 이름이 ‘ 김XX ’인  저자의 도서명, isbn, 출판사를 출력하는 기능을 작성한다. (return -> void) 
			System.out.println("\n============== 김xx 저자의 도서명 검색결과 ==============\n");
			try{
				dao.findBookByAuthorKim();
			}catch (RecordNotFoundException| DMLException e) {
				System.out.println(e.getMessage());
			}
			
			//5. Author 테이블에 있는 저자명 별로 출간된 도서들을 도서명, 출판사, 가격, 저자명을 출력하는 기능을 구현한다. 
			System.out.println("\n============== Author 테이블에 있는 저자명 별 확인 ==============\n");
			try{
				dao.groupAuthor();
			}catch (RecordNotFoundException | DMLException e) {
				System.out.println(e.getMessage());
			}
			
			//6. Book 테이블에 있는 title와 publisher를 이용하여 서로의 관계를 다음과 같이 출력되도록 기능을 구현한다. ( ‘IoT세상은 미래닷컴에서 출판했다’)
			System.out.println("\n============== title와 publisher를 이용하여 서로의 관계 ==============\n");
			try{
				dao.relationBook();
			}catch (RecordNotFoundException | DMLException e) {
				System.out.println(e.getMessage());
			}
			
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
	}
}
