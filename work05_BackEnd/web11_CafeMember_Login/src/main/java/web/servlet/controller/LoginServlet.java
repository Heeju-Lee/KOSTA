package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {

    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 1. 폼값을 받아서
		 2. DAO 리턴받고 비즈니스로직 호출...결과값 반환
		 3. 세션받아와서 바인딩(vo가 있어야 함)
		 4. 네비게이션
		  	결과 페이지
		 	login_result.jsp
		*/	
		
		/*
		 * request.setCharacterEncoding("utf-8");
		 * response.setContentType("text/html;charset=utf-8");
		 */
		
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
		request.getRequestDispatcher(path).forward(request, response);
	}

}
