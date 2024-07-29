package com.edu.vo;

public class NoteBook extends Product {
	//제조사
	private String company; 
	
	public NoteBook(String name, int price, String info, String category, String company) {
		super(name, price, info, category);
		this.company = company;
	} 
}
