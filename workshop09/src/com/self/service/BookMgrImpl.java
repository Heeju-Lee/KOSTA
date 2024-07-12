package com.self.service;

import java.util.ArrayList;
import java.util.List;

import com.self.vo.Book;
import com.self.vo.Magazine;

public class BookMgrImpl implements BookMgr{
	private ArrayList<Book> books = null;
	//싱글톤
	private static BookMgrImpl mgr = new BookMgrImpl();
	private BookMgrImpl() {
		books = new ArrayList<Book>();
	}
	public static BookMgrImpl getInstance() {
		return  mgr;
	}
	
	@Override
	public void addBook(Book b) {
		books.add(b);//맞음.
	}

	@Override
	public ArrayList<Book> getAllBook() {
		return books;
	}

	@Override
	public Book searchBookByIsbn(String isbn) {
		Book book = null;
		for(Book b : books) {
			if(b.getIsbn().equals(isbn))
				return b;
		}
		return book;///끝남
	}

	@Override
	public ArrayList<Book> searchBookByTitle(String title) {
		ArrayList<Book> temp = new ArrayList<>();
		for(Book b: temp)
			if(b.getTitle().equals(title))
				temp.add(b);
		return temp;
	}

	@Override
	public ArrayList<Book> onlySearchBook() {
		ArrayList<Book> temp = new ArrayList<>();
		//
		
		return temp;
	}//안해도돼~!~!

//	@Override
//	public ArrayList<Book> onlySearchMagazin() {
//		ArrayList<Book> temp = new ArrayList<>();
//		for(Book b:temp)
//			if(b instanceof Magazine);
//				temp = b.toString();			
//			
//			return temp;
//	}

	@Override
	public ArrayList<Book> magazineOfThisYearInfo(int year) {
		ArrayList<Book> temp = new ArrayList<>();
		//
		
		return temp;
	}

	@Override
	public ArrayList<Book> searchBookByPublish(String publish) {
		ArrayList<Book> temp = new ArrayList<>();
		//
		
		return temp;
	}

	@Override
	public ArrayList<Book> searchBookByPrice(int price) {
		ArrayList<Book> temp = new ArrayList<>();
		//
		
		return temp;
	}

	@Override
	public int getTotalPrice() {
		int total = 0;
//		for(Book b )
//		
		return total;
	}
	@Override
	public int getAvgPrice() {		
		//
		return 0;
	}
	@Override
	public ArrayList<Book> onlySearchMagazin() {
		// TODO Auto-generated method stub
		return null;
	}
}
