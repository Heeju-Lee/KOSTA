package com.self.vo;

public class Novel extends Book{
	private String genre;
	private double rating;
	
	Novel(){}

	public Novel(int isbn, String title, String author, String publisher, double price, String genre, double rating) {
		super(isbn, title, author, publisher, price);
		this.genre = genre;
		this.rating = rating;
	}

	public String getGenre() {
		return genre;
	}
	
	public double getrating() {
		return rating;
	}

	public String toString() {
		return super.toString()+", Genre:"+genre+", Rating:"+rating;
	}
	
}
