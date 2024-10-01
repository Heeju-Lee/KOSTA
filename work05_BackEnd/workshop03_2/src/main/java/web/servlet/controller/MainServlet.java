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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 1. 폼값받아서
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 2. DAO 비즈니스로직 호출..이때 폼값을 인자값으로(가장중요함) //3. 디비 반환 값 받아서
		User user = new User(id, password, "홍길동", "종로구");
		// 4. 바인딩....setAttribute()
		
		// 5. 네비게이션 (servlet의 마지막으로 하는일 fix)
		if (user.getId().equals("kosta") && user.getPassword().equals("1234")) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("LoginSuccess").forward(request, response);
		} else
			request.getRequestDispatcher("LoginError").forward(request, response);
	}

}
