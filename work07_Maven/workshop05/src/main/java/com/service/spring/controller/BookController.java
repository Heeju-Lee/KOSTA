package com.service.spring.controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.Book;
import com.service.spring.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("bookList.do")
	public ModelAndView getBooks() throws Exception{
		List<Book> list=bookService.getBooks();
		return new ModelAndView("book/bookList","list",list);
	}
	
	@PostMapping("bookRegister.do")
	public ModelAndView register(HttpServletRequest request, Book book, String isbn1, String isbn2, String isbn3)throws Exception{
		System.out.println("register BookVO before:: "+book);//?
		
		String msg = "도서 등록에 실패했습니다.";
		String path = "redirect:Error.jsp";
				
		String isbn = isbn1+"-"+isbn2+"-"+isbn3;
		book.setIsbn(isbn);
		
		try {
			bookService.insertBook(book);
			System.out.println("register BookVO After:: "+book);//
			
			msg = "책 정보가 정상적으로 등록되었습니다.";
			path ="redirect:result.jsp";
		}catch(DuplicateKeyException e) {
			//디비에 book정보가 정상적으로 입력되지 않았다면
			System.out.println("register 실패....키중복"+e.getMessage());
			msg = "isbn 중복되었습니다. 다시 등록 시도해주세요.";
		}catch (SQLException e) {
			System.out.println("register 실패...."+e.getMessage());
		}
		//redirect session 바인딩
		request.getSession().setAttribute("msg", msg);
		return new ModelAndView(path);
	}
	
	@GetMapping("bookSearch.do")
    public ModelAndView search(String searchField, String searchText, HttpServletRequest request) throws Exception{ 
		
		List<Book> list = null;
		Book book = new Book();

		String msg = "도서 검색 중 오류가 발생했습니다.";
		String path = "redirect:Error.jsp";
		
		try {
			//String 값이 들어갈 때는 반드시 JDK버전 8버전 이상이어야 한다.
			switch(searchField) {
				case "TITLE":
					list = bookService.searchByTitle(searchText);
				break;
				case "PUBLISHER":
					list = bookService.searchByPublisher(searchText);
				break;
				case "PRICE":
					int price = Integer.parseInt(searchText);
					list = bookService.searchByPrice(price);
				break;
				default: 
					list = bookService.getBooks();
			}//switch
			path = "book/bookList";//InternalResourceViewResolver 작동
			msg = "도서 검색을 정상적으로 수행했습니다.";
			
			request.setAttribute("field", searchField);
			request.setAttribute("text", searchText);
			
		}catch(Exception e) {
			System.out.println("serarch... 수행중 에러"+e.getMessage());
		}
		return new ModelAndView(path, "list", list);//forwarding...request 에 자동바인딩 될 것임.
	}
	@GetMapping("bookView.do")
    public ModelAndView bookview(String isbn)throws Exception{
		Book book = new Book();
		
		//default msg  & path
		String msg = "isbn으로 검색 중 오류가 발생했습니다.";
		String path = "redirect:Error.jsp";
		
		try {
			book = bookService.searchByIsbn(isbn);
			path = "book/bookView";//InternalResourceViewResolver 작동
			msg = "isbn으로 검색 성공";
		}catch(Exception e) {
			System.out.println("bookview 수행 중 에러 발생"+e.getMessage());
		}
		return new ModelAndView(path,"book",book);//forwarding...request 에 자동바인딩 될 것임.
	}	
}//





