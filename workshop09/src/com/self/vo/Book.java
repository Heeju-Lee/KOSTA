package com.self.vo;
public class Book {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private String desc;
	
	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}

	public String getIsbn()
	{
		return isbn;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getPublisher()
	{
		return publisher;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	@Override
	public String toString() {
		return "isbn : " + isbn + ", title : " + title + ", author : " + author + ", publisher : " + publisher
				+ ", price : " + price + ", desc : " + desc;
	}
	
	
}
