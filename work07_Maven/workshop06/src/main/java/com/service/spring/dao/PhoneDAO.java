package com.service.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;

@Repository
public class PhoneDAO {
	
	private static String NS = "sql.pms.Phone."; 
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public int insert(Phone phone) {
		return sqlSession.insert(NS+"insert",phone);
	}
	
	public List<Phone> select(Phone phone){
		return sqlSession.selectList(NS+"select",phone);
	}
	
	public UserInfo selectUser(UserInfo userInfo){
		return sqlSession.selectOne(NS+"selectUser", userInfo);
	}
	
	public int delete(List<Phone> list) {
		return sqlSession.delete(NS+"delete",list);
	}
	
	public int update(Phone phone) {
		return sqlSession.update(NS+"update",phone);
	}
}
