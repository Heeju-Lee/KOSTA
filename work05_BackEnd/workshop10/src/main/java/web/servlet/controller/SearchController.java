package web.servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Book;
import web.servlet.model.BookDAOImpl;
import web.servlet.model.User;
import web.servlet.model.UserDAOImpl;

public class SearchController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String searchSelect = request.getParameter("searchSelect");
		String searchText = request.getParameter("searchText");
		String path = "index.jsp";
		
		System.out.println("aaaaaaaaaaaa ..."+searchText);
		try {
			ArrayList<Book> list = BookDAOImpl.getInstance().findBookList(searchSelect, searchText);
			
			request.setAttribute("list", list);
			path = "book/bookList.jsp";
		}catch(Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(path);
	}
}
