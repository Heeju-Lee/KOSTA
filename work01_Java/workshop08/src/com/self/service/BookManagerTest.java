package com.self.service;

import com.self.vo.Book;
import com.self.vo.Magazine;
import com.self.vo.Novel;

public class BookManagerTest {

	public static void main(String[] args) {

		BookManager manager = BookManager.getInstance();

		manager.insertBook(new Magazine(11111111, "월간식당 잡지 7월호", "월간식당 편집국", "더본", 18000, "요리"));
		manager.insertBook(new Magazine(11111112, "W 7월호", "W 편집국", "AM출판", 23000, "패션"));
		manager.insertBook(new Novel(22222222, "ABC 살인사건", "애거서 크리스티", "해문", 15000, "추리", 5));
		manager.insertBook(new Novel(22222223, "BBB 살인사건", "애거서 크리스티", "해문", 16000, "스릴러", 4.9));
		manager.insertBook(new Novel(22222224, "CCC 살인사건", "애거서 크리스티", "해문", 18000, "추리", 5));

		System.out.println("=============== getAllBook ===============");
		Book[] books = manager.getAllBook();
			for(Book b: books) {
				if(b==null)
					break;
				System.out.println(b);
			}		
		System.out.println("=============== getNumberOfBooks ===============");
		System.out.println(manager.getNumberOfBooks());
		
		System.out.println("=============== SearchBookByISBN ===============");
		manager.SearchBook(11111111);
		
		System.out.println("=============== SearchBookByTitle or Publisher ===============");
		manager.SearchBook("ABC 살인사건");
		manager.SearchBook("AM출판");
		
		System.out.println("=============== SearchBookByPrice(Min:15000,Max:20000) ===============");		
		manager.SearchBook(15000,20000);
		
		System.out.println("=============== getSumPriceOfBook ===============");		
		System.out.println(manager.getSumPriceOfBook());
		
		System.out.println("=============== getAvgPriceOfBook ===============");		
		System.out.println(manager.getAvgPriceOfBook());
		
		
	}
}
