package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.User;
import web.servlet.model.UserDAOImpl;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 폼값받아서
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path = "login.html";

		// 2. DAO 비즈니스로직 호출..이때 폼값을 인자값으로(가장중요함) //3. 디비 반환 값 받아서
		try {
			User rvo = UserDAOImpl.getInstance().login(id,password);
			
			// 4. 바인딩....setAttribute()
			HttpSession session = request.getSession();
			
			if(rvo != null) {
				session.setAttribute("vo", rvo);
				path = "loginSuccess.jsp";
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		path = "loginError.jsp";
		response.sendRedirect(path);
	}
}
