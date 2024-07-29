package com.edu.vo;

public class AirConditioner extends Product {
	
	private boolean stand;
	
	public AirConditioner(String name, int price, String info, String category, boolean stand) {
		super(name, price, info, category);
		this.stand = stand;
	} 
}
