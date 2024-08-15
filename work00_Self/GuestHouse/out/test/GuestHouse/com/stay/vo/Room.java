package com.stay.vo;

public class Room {
	int num;
	int price;
	int capacity;
	
	public Room() {}
	public Room(int num, int price, int capacity) {
		super();
		this.num = num;
		this.price = price;
		this.capacity = capacity;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Room [num=" + num + ", price=" + price + ", capacity=" + capacity + "]";
	}

}
