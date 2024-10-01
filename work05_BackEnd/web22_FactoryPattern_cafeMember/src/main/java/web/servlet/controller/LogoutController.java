package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "login.jsp";
		
		try {
			//세선을 죽이는 로직... logout
			HttpSession session = request.getSession();
			
			if(session.getAttribute("vo")!=null) {//로그인이 되어져 있다면
				session.invalidate();
				
				path = "logout.jsp";
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return new ModelAndView(path);
	}
}
