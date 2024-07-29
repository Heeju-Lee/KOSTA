package com.self.vo;

public class Magazine extends Book{
	private String relatedSubject;
	
	Magazine(){}

	public Magazine(int isbn, String title, String author, String publisher, double price, String relatedSubject) {
		super(isbn, title, author, publisher, price);
		this.relatedSubject = relatedSubject;
	}

	public String getRelatedSubject() {
		return relatedSubject;
	}

	public String toString() {
		return super.toString()+", Related Subject:"+relatedSubject;
	}
}
