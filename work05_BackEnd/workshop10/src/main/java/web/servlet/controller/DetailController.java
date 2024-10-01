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

public class DetailController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String bookisbn = request.getParameter("bookisbn");
		String path = "index.jsp";
		
		try {
			String detail = BookDAOImpl.getInstance().detailBook(bookisbn);
			request.setAttribute("detail", detail);
			
			path = "book/bookDetail.jsp";
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		path = "book/bookDetail.jsp";
		return new ModelAndView(path);
	}
}
