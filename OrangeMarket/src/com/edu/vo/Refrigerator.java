package com.edu.vo;

public class Refrigerator extends Product {
	//capacity
	private int capacity;

	public Refrigerator(String name, int price, String info, String category, int capacity) {
		super(name, price, info, category);
		this.capacity = capacity;
	} 
	
	
}
