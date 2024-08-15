package com.stay.vo;

import java.util.ArrayList;

public class GuestHouse {
	String id;
	String name;
	String address;
	double rating;
	
	ArrayList<Room> rooms = new ArrayList<>();

	public GuestHouse() {}

	public GuestHouse(String id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public GuestHouse(String id, String name, String address, ArrayList<Room> rooms) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.rooms = rooms;
	}

	public GuestHouse(String id, String name, String address, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.rating = rating;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getRating() {
		return rating;
	}

	@Override
	public String toString() {
		return "GuestHouse [숙소번호 : " + id + ", 숙소명 : " + name + ", 주소 : " + address + ", 방정보 : " + rooms + "]";
	}

	public String includeRating() {
		return "GuestHouse [숙소번호 : " + id + ", 숙소명 : " + name + ", 주소 : " + address + ", 평점 : "+rating+"]";
	}

}
