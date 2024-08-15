package com.stay.vo;

public class Customer {
	String id;	
	String name;
	String pass;
	String phone;
	
	public Customer(){}
	public Customer(String id, String name, String pass, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.phone = phone;
	}
	public Customer(String id, String pass, String phone) {
		this.id = id;
		this.pass = pass;
		this.phone = phone;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", pass=" + pass + ", phone=" + phone + "]";
	}

}
