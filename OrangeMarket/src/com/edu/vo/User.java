package com.edu.vo;

public class User {
	
	
	private String id;
	private String password;
	private String name;
	private MyDate date;
	
	//=============================
	private int point;
	private String email;
	private String address;
	private String phoneNumber;
	
	public User(String id, String password, String name, MyDate date) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.date = date;
	}

	public User(String id, String password, String name, MyDate date, String email, String address,String phoneNumber) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.date = date;
		this.point = point;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyDate getDate() {
		return date;
	}

	public void setDate(MyDate date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "[User] id: " + id + ", name: " + name + ", date: " + date;
	}
	
	
	
	
	
	

}
