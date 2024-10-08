package com.service.spring.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.dao.PhoneDAO;
import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;

@Repository
public class PhoneService {

	@Autowired
	private PhoneDAO phoneDAO;
	
	public int insert(Phone phone) {
		return phoneDAO.insert(phone);
	}
	
	public List<Phone> select(Phone phone){
		return phoneDAO.select(phone);
	}
	
	public UserInfo selectUser(UserInfo userInfo){
		return phoneDAO.selectUser(userInfo);
	}
	
	public int delete(List<Phone> numList) {
	    return phoneDAO.delete(numList);
	}//delete
	
	public int update(Phone phone) {
		return phoneDAO.update(phone);
	}
}
