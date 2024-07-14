package com.edu.repository;

import java.util.HashMap;
import java.util.Map;

import com.edu.service.LoginService;
import com.edu.vo.MyDate;
import com.edu.vo.User;

public class UserRepository {
	
	//String id, String password, String name, MyDate date
	// HashMap 선언 및 초기화
	
    HashMap<String, User> users;
    
    public void setHashMap(HashMap<String, User> user) {
    	this.users = user;
    }
    
    public HashMap<String, User> getHashMap() {
    	return users;
    }
	
	public void add(String id, User user) {
		users.put(id, user);
	}

	public void find(HashMap<String, User> user) {
		
		
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
