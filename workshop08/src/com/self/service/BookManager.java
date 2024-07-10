/**
 * @author LEE HEE JU
 * @version Bookmanager version 1.0
 * @since JDK 17
 */
package com.self.service;


import com.self.vo.Book;

public class BookManager {
	/**
	 * @param Book의 배열의 길의 최대값 지정
	 * @param Book 배열 선언
	 * @param numberOfBook 저장되어 있는 책의 수
	 * @param idx 배열에서 사용할 인덱스 값
	 */
	private static final int MAX_BOOKS =100;
	private Book[] bmgr;
	private int numberOfBook;
	private int idx;
	
	/**
	 * singleton pattern 생성
	 */
	static private BookManager manager = new BookManager();

	private BookManager() {
		bmgr = new Book[MAX_BOOKS];//설정한 사이즈로 빈 컨테이너 생성
		numberOfBook = 0;
		idx = 0;
	}
	/**
	 * 
	 * @return singleton으로 생성된 manager 
	 */
	public static BookManager getInstance() {
		return manager;
	}
	/**
	 * @param b
	 * 오픈 도서관에 책 정보를 추가
	 */
	public void insertBook(Book b) {
		if(idx<MAX_BOOKS)
			bmgr[idx++]=b;
	}
	/**
	 * @return 저장된 책의 수를 반환
	 */	
	public int getNumberOfBooks() {
		for(Book b : bmgr) {
			if(b==null) break;
			numberOfBook++;
		}return numberOfBook;
	}
	/**
	 * @return 저장된 모든 책의 정보를 반환
	 */	
	public Book[] getAllBook() {
		Book[] bList = new Book[MAX_BOOKS];
		int idx=0;
		
		for(Book b : bmgr) {
			if(b!=null) {
				bList[idx++]= b;
			}	
		}return bList;
	}
	/**
	 * @return ISBN으로 책 정보를 검색
	 */	
	public Book SearchBook(int isbn) {
		for(Book b : bmgr) {
			if(b==null)
				break;
			if(b.getIsbn()==isbn) {
				System.out.println(b.toString());				
			}
		}return null;
	}
	/**
	 * @return 책 제목 또는 출판사 명으로 책 정보 검색
	 */	
	public Book[] SearchBook(String s) {
		Book[] request = new Book[MAX_BOOKS];

		for(Book b : bmgr) {
			if(b==null)
				break;
			if(b.getTitle().equals(s)) {
				request[idx++] = b;
				System.out.println(b.toString());
			}
			if(b.getPublisher().equals(s)) {
				request[idx++] = b;
				System.out.println(b.toString());	
			}
		}return null;
	}
	/**
	 * @return 최소, 최대 가격을 입력해 책 정보 검색
	 */	
	public Book SearchBook(double min, double max) {
		for(Book b : bmgr) {
			if(b==null)
				break;
			if(b.getPrice()>=min && b.getPrice()<=max) {
				System.out.println(b.toString());				
			}
		}return null;
	}
	/**
	 * @return 저장된 책 가격 전부의 가격을 검색 
	 */	
	public double getSumPriceOfBook() {
		double sum = 0;
		
		for(Book b : bmgr) {
			if(b==null) break;
			sum += b.getPrice();
		}
		return sum;
	}
	/**
	 * @return 저장된 책 가격 전부의 평균가격을 검색
	 */	
	public double getAvgPriceOfBook() {
		double avg = 0;
		
		for(Book b : bmgr) {
			if(b==null) break;
			avg = getSumPriceOfBook()/numberOfBook;
		}
		return avg;
	}
	
}

