package com.service.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Item;

//POJO 기반
@Repository
public class ItemDAO {
	public static final String NS = "ns.sql.FruitsMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	public Item getItem(Integer itemId) throws Exception{
		return sqlSession.selectOne(NS+"getItem", itemId);
	}
	
	public List<Item> getItemList() throws Exception{
		return sqlSession.selectList(NS+"getItemList");
	}
}
