package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.User;
import web.servlet.model.UserDAOImpl;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println("Seervlet..."+id);
		String path = "index.jsp";
		try {
			User rvo = UserDAOImpl.getInstance().login(id, password);

			HttpSession session = request.getSession();

			if (rvo != null) {
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID: " + session.getId());
				path = "loginSuccess.jsp";
				return new ModelAndView(path);
			
			}
		} catch (SQLException e) {
			path = "./error/error.html";
		}
		return new ModelAndView(path);
	}
}
