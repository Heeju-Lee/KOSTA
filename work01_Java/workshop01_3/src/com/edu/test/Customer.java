package com.edu.test;

public class Customer {
	String name;
	String address;
	
	//setter 주입예정
	Account account;
	
	//기본
	public Customer() {}
	
	// 생성자
	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
	}

	//setter 주입
	public void openAccount(Account account) {
		this.account = account;
	}
	
	public Account getAccount() {
		return account;
	}
		
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getCustomerInfo() {
		return name+", "+address;
	}
		
}
	