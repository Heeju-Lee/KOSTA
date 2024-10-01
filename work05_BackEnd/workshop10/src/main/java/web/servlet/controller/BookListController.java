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

public class BookListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<Book> list;
		String path = "index.jsp";
		try {
			list = BookDAOImpl.getInstance().showAllBook();			
			request.setAttribute("list", list);
			path = "book/bookList.jsp";
		} catch (SQLException e) {
			System.out.println(e);
		}
		return new ModelAndView(path);
	}
}
