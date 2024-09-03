package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

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
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String command = request.getParameter("command");
		String path = "login.html";
		
		if(command.equals("login")) {
			login(request, response);
		}else if(command.equals("addBook")) {
			addBook(request, response);
		}
		
	}//doProcess
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//mainServlet(login)
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		String path = "loginError.jsp";

		try {
			User rvo = UserDAOImpl.getInstance().login(id,password);
			
			HttpSession session = request.getSession();
			
			if(rvo != null) {
				session.setAttribute("vo", rvo);
				path = "loginSuccess.jsp";
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		response.sendRedirect(path);
		
	}//login
	
	protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] isbns  = request.getParameterValues("bookNo");
		
        String isbn = "";
        for (int i = 0; i < isbns.length; i++) {
            isbn += isbns[i];
            if (i < isbns.length - 1) {
                isbn += "-"; // 각 번호 사이에 하이픈 추가
            }
        }

		String bookTitle = request.getParameter("bookTitle");
		String bookCategory = request.getParameter("bookCategory");
		String bookCountry = request.getParameter("bookCountry");
		String bookDate = request.getParameter("bookDate");
		String bookPublisher = request.getParameter("bookPublisher");
		String bookAuthor = request.getParameter("bookAuthor");
		int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
		String bookSummary = request.getParameter("bookSummary");
		
		Book vo = new Book(isbn, bookTitle, bookCategory, bookCountry, bookDate, bookPublisher, bookAuthor, bookPrice, bookSummary);
		
		try {
			BookDAOImpl.getInstance().registerBook(vo);
						
			request.getRequestDispatcher("/book/bookSuccess.jsp").forward(request, response);

		} catch (SQLException e) {
			System.out.println(e);
			
			response.sendRedirect("../error/error.html");
		}	
	}//addBook
	
	protected void searchBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter(getServletName());
		String keyword = request.getParameter(getServletName());
		
		try {
			BookDAOImpl.getInstance().searchBooks(option, keyword);
						
			request.getRequestDispatcher("/book/bookSuccess.jsp").forward(request, response);

		} catch (SQLException e) {
			System.out.println(e);
			
			response.sendRedirect("../error/error.html");
		}	
	}//addBook
}
