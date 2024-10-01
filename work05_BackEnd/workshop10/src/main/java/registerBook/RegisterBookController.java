package registerBook;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.controller.Controller;
import web.servlet.controller.ModelAndView;
import web.servlet.model.Book;
import web.servlet.model.BookDAOImpl;

public class RegisterBookController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		String path = "index.jsp";
		
		try {
			dao.registerBook(book);
			System.out.println("registerBook....");
			request.setAttribute("book", book);
			request.setAttribute("msg", "책 정보가 정상적으로 저장되었습니다.");
			path = "book/bookSuccess.jsp";
			
		} catch (SQLException e) {
			System.out.println("Register Failed.");
			request.setAttribute("msg", "책 등록중 오류발생...정보저장 실패!!");
			path  = "../error/error.html";  // error 페이지로 이동
		}	
		return new ModelAndView(path);
	}
}
