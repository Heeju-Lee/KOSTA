package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.User;

@WebServlet("/front.do")
public class frontCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public frontCotroller() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");
		String path = "index.jsp";
		
		if (command.equals("register")) {
			register(request, response);
		}else if(command.equals("login")) {
			path = login(request, response);
		}else if(command.equals("logout")) {
			path = logout(request, response);
		}
		request.getRequestDispatcher(path).forward(request, response);

	}// doProcess

	protected void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}// register

	protected String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("userId");
		String password = request.getParameter("Password");

		User vo = new User("kosta", "1111", "nickName", "phoneNum", "address");
		try {
			HttpSession session = request.getSession();

			if (vo.getId().equals(id) && vo.getPw().equals(password)) {
				session.setAttribute("vo", vo);
				System.out.println("JSESSIONID: " + session.getId());
				return "./loginSuccess.jsp";
			} else {
				return "./error/error.jsp";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}// login
	
	private String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "index.jsp";
		
		try {
			HttpSession session = request.getSession();
			
			if(session.getAttribute("vo")!=null) {//로그인이 되어져 있다면
				session.invalidate();
				
				path = "logout.jsp";
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return path;
	}
}// class
