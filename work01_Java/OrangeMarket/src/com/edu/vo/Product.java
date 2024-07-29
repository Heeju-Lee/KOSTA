package com.edu.vo;

public abstract class Product {
	private String name;
	private int price;
	private String info;
	private String category;
	
	public Product(String name, int price, String info, String category) {
		this.name = name;
		this.price = price;
		this.info = info;
		this.category = category;
	}

	@Override
	public String toString() {
		return "[Product] name: " + name + ", price: " + price + ", info: " + info + ", category: " + category;
	}
	
	
	
	
}
