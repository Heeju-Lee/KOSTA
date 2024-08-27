package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.User;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MainServlet() {

    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 폼값받아서
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//2. DAO 비즈니스로직 호출..이때 폼값을 인자값으로 //3. 디비 반환 값 받아서
		User user = new User("kosta", "1234", "홍길동", "종로구");
		
		//4. 바인딩....setAttribute()
		request.setAttribute("user", user);
		
		//5. 네비게이션
		if(user.getId().equals(id) && user.getPassword().equals(password)) {
			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
		}
		else request.getRequestDispatcher("loginError.jsp").forward(request, response);
	}

}
