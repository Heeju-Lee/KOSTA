package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

/*
 * Component란?
 * 인터페이스 기반으로 작성된 재사용성 강한 자바 클래스
 * 폼값 받아서 
 * DAO 리턴받고 비지니스 로직 호출...데이타 반환
 * 바인딩
 * 네비게이션
*/
public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		String path ="index.html";
		
		try {
			Member rvo = MemberDAOImpl.getInstance().login(id, pass);
			HttpSession session = request.getSession();
			
			if(rvo != null) { //null인경우 바인딩 진행 안되도록..
				session.setAttribute("vo", rvo);
				System.out.println("LoginServlet ... JSESSIONID :::"+session.getId());
				path = "login_result.jsp";				
			}
		}catch (SQLException e) {
			System.out.println(e);
			path = "login_fail.jsp";	
		}
		return new ModelAndView(path);
	}
}
