package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Book;
import web.servlet.model.BookDAOImpl;
import web.servlet.model.User;
import web.servlet.model.UserDAOImpl;


@WebServlet("/front.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println("Command..."+command);
		String path = "index.jsp";
		if(command.equals("login")) {
			path = login(request, response);
		}else if(command.equals("logout")) {
			path = logout(request, response);
		}else if(command.equals("registerBook")) {
			path = registerBook(request, response);
		}else if(command.equals("bookList")) {
			path = bookList(request, response);
		}else if(command.equals("search")) {
			path = search(request, response);
		}  
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	private String search(HttpServletRequest request, HttpServletResponse response) {
		String searchSelect = request.getParameter("searchSelect");
		String searchText = request.getParameter("searchText");
		System.out.println("aaaaaaaaaaaa ..."+searchText);
		try {
			ArrayList<Book> list = BookDAOImpl.getInstance().findBookList(searchSelect, searchText);
			
			request.setAttribute("list", list);
		
		}catch(Exception e) {
			System.out.println(e);
		}
		return "book/bookList.jsp";
	}

	private String bookList(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Book> list;
		try {
			list = BookDAOImpl.getInstance().showAllBook();			
			request.setAttribute("list", list);
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return "book/bookList.jsp";
		
	}

	private String registerBook(HttpServletRequest request, HttpServletResponse response) {
		String[] bookNoList = request.getParameterValues("bookNo");
		String isbn = "";
		for(int i=0; i<bookNoList.length; i++) {
			if(i==bookNoList.length-1) {
				isbn += bookNoList[i];
			} else {
				isbn += bookNoList[i] + "-";
			}
		}
		String title = request.getParameter("bookTitle");
		String catalogue = request.getParameter("bookCategory");
		String nation = request.getParameter("bookCountry");
		String publish_date = request.getParameter("bookDate");
		String publisher = request.getParameter("bookPublisher");
		String author = request.getParameter("bookAuthor");
		int price = Integer.parseInt(request.getParameter("bookPrice"));
		String description = request.getParameter("bookSummary");
		
		Book book = new Book(isbn, title, catalogue, nation, publish_date, publisher, author, price, description);
		System.out.println("Book..."+book);
		BookDAOImpl dao = BookDAOImpl.getInstance();
		
		try {
			dao.registerBook(book);
			System.out.println("registerBook....");
			request.setAttribute("book", book);
			return "book/bookSuccess.jsp";
			
		} catch (SQLException e) {
			System.out.println("Register Failed.");
			return "../error/error.html";  // error 페이지로 이동
		}		
	}

	private String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if(session.getAttribute("vo") !=null) {
			session.invalidate();
			return "logout.jsp";
		}
		return null;
	}

	private String login(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println("Seervlet..."+id);
		try {
			User rvo = UserDAOImpl.getInstance().login(id, password);

			HttpSession session = request.getSession();

			if (rvo != null) {
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID: " + session.getId());
				return "loginSuccess.jsp";
			
			}
		} catch (SQLException e) {
			return "./error/error.html";
		}
		return null;
	}

}
