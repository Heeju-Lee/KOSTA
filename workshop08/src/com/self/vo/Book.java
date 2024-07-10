package com.self.vo;

public class Book {

	private int isbn;
	private String title;
	private String author;
	private String publisher;
	private double price;
	
	Book (){}

	public Book(int isbn, String title, String author, String publisher, double price) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}

	public int getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void changePublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void changePrice(double price) {
		this.price = price;
	}
		
	public String toString() {
		return "ISBN. "+isbn+", Title: "+title+", author: "+author+", publisher: "+publisher+", price: "+price;
	}
	
	
	
	
	
	
}
