package com.service.spring.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.BookDAO;
import com.service.spring.domain.Book;

@Service
public class BookService {

	@Autowired	
	private BookDAO bookDAO;
	
	public void insertBook(Book vo) throws Exception{	
		bookDAO.insertBook(vo);
	}
	
	public List<Book> getBooks() throws Exception{
        List<Book> list = bookDAO.getBooks();        
        return list;
	}
	
	public List<Book> searchByTitle(String word) throws Exception{
        List<Book> list = bookDAO.searchByTitle(word);
        return list;
	}

	public List<Book> searchByPublisher(String word) throws Exception{
		List<Book> list = bookDAO.searchByPublisher(word);        
        return list;
	}
	
	public List<Book> searchByPrice(int price) throws Exception{
		List<Book> list = bookDAO.searchByPrice(price);
        return list;
	}

	public Book searchByIsbn(String word) throws Exception{        
		Book vo = bookDAO.searchByIsbn(word);        
        return vo;
	}

	
	public void delete(String word) throws Exception{
		bookDAO.delete(word);;
	}
	
	
	public Book getIsbn(String word) throws Exception{
        return bookDAO.getIsbn(word);
	}
	
	public void update(Book vo) throws Exception{
		bookDAO.update(vo);
	}		
}
