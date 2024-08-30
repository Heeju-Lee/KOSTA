package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Book;
import web.servlet.model.BookDAOImpl;

@WebServlet("/book/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
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
						
			request.getRequestDispatcher("bookSuccess.jsp").forward(request, response);

		} catch (SQLException e) {
			System.out.println(e);
			
			response.sendRedirect("../error/error.html");
		}	
			
	}

}
