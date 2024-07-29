package com.edu.service;

import java.nio.file.LinkOption;
import java.util.HashMap;

import com.edu.repository.UserRepository;
import com.edu.vo.MyDate;
import com.edu.vo.User;

public class LoginService {
	
	private UserRepository ur;
	
	public LoginService() {}
	
	public LoginService(UserRepository ur) {
	this.ur = ur;
	}

    // 회원가입(C)
    public void register(User user) {
    	ur.add(user.getId(), user);//key 값 = id & value = 회원가입으로 받은 user 정보
    	System.out.println(user.getName() + "님 회원가입이 완료되었습니다.");
    	//System.out.println(ur.getHashMap().values()); userRepository 저장 확인용
    }

    // 로그인 메소드
    public boolean login(String id, String password) {
        if (ur.getHashMap().containsKey(id)) {
            User user = ur.getHashMap().get(id);
            if (user.getPassword().equals(password)) {
                System.out.println("로그인 성공!\n");
                return true;//성공하면 orange market mainpage로 이동해야 함.
            } else {
                System.out.println("비밀번호가 일치하지 않습니다. 다시 시도해주세요.\n");
            }
        } else {
            System.out.println("ID가 존재하지 않습니다. 다시 시도해주세요.\n");
        }
        return false;//
    }
    
    // 아이디 찾기 메소드(R)
	public void findId(String userName, String userPhoneNumber) {
	    boolean found = false;
	    for (User user : ur.getHashMap().values()) {
	        if (user.getName().equals(userName) && user.getPhoneNumber().equals(userPhoneNumber)) {
	            System.out.println("아이디는: " + user.getId() + " 입니다.");
	            found = true;
	            break;
	        }
	    }if (!found) {
	        System.out.println("등록된 아이디가 아닙니다. 다시 확인해주십시오.");
	    }
	}
    
    // 패스워드 찾기 메소드(R)
	public void findPw(String userId, String userName) {
        if (ur.getHashMap().containsKey(userId)) {
            User user = ur.getHashMap().get(userId);
            if (user.getName().equals(userName)) {
                System.out.println("패스워드는: " + user.getPassword() + " 입니다.");
            } else {
                System.out.println("아이디와 일치하는 이름이 없습니다.");
            }
        } else {
            System.out.println("입력하신 아이디가 존재하지 않습니다.");
        }
	}
}
