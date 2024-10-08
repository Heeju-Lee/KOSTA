package com.service.spring.dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.dao.BookDAO;
import com.service.spring.domain.Book;

@Repository
public class BookDAO {
	public static final String NS = "ns.sql.BookMapper.";
	
	@Autowired	
	private SqlSession sqlSession;
	
	public void insertBook(Book vo) throws Exception{	
		sqlSession.insert(NS+"insertBook", vo);
	}
	
	public List<Book> getBooks() throws Exception{
        List<Book> list = sqlSession.selectList(NS+"getBooks");        

        return list;
	}
	
	public List<Book> searchByTitle(String word) throws Exception{
        List<Book> list = sqlSession.selectList(NS+"searchByTitle", word);
        return list;
	}

	public List<Book> searchByPublisher(String word) throws Exception{
		List<Book> list = sqlSession.selectList(NS+"searchByPublisher", word);        
        return list;
	}
	
	public List<Book> searchByPrice(int price) throws Exception{
		List<Book> list = sqlSession.selectList(NS+"searchByPrice", price);
        return list;
	}

	public Book searchByIsbn(String word) throws Exception{        
		Book vo = sqlSession.selectOne(NS+"searchByIsbn", word);        
        return vo;
	}

	
	public void delete(String word) throws Exception{
		sqlSession.delete(NS+"delete", word);
	}
	
	
	public Book getIsbn(String word) throws Exception{
		
        return sqlSession.selectOne(NS+"getIsbn", word);
	}
	
	public void update(Book vo) throws Exception{
		sqlSession.update(NS+"update", vo);
	}	
	
}
