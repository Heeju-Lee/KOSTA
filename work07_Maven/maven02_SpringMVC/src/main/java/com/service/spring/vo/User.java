package com.service.spring.vo;

public class User {
	private String userName;
	private String userAddr;
	private String id;
	private String password;
	
	public User() {}
	public User(String userName, String userAddr, String id, String password) {
		this.userName = userName;
		this.userAddr = userAddr;
		this.id = id;
		this.password = password;
	}//constructor
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
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
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userAddr=" + userAddr+"]";
	}//toString
}//class
