package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Article;
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
		}else if(command.equals("writePost")) {
			path = writePost(request, response);
		}else if(command.equals("updatePost")) {
			path = updatePost(request, response);
		}else if(command.equals("deletePost")) {
			path = deletePost(request, response);
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
		String msg = "";

		User vo = new User("adorable", "1234", "절미", "01048778976", "인천");
		try {
			HttpSession session = request.getSession();

			if (vo.getId().equals(id) && vo.getPw().equals(password)) {
				session.setAttribute("vo", vo);
				System.out.println("JSESSIONID: " + session.getId());
				return "./loginSuccess.jsp";
			} else {
				msg = "아이디와 비밀번호를 확인해주세요.";
				request.setAttribute("msg", msg);
				return "./error/Error.jsp";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}// login
	
	private String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "index.jsp";
		String msg = "";
		
		try {
			HttpSession session = request.getSession();
			
			if(session.getAttribute("vo")!=null) {
				session.invalidate();
				
				path = "logout.jsp";
				msg = "로그아웃 되셨습니다. 다음에 또 오세요 멍멍";
				request.setAttribute("msg", msg);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return path;
	}//logout
	
	private String writePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "index.jsp";
		
		String category = request.getParameter("category");
		String title = request.getParameter("title");
		String nickName = request.getParameter("nickName");
		String content = request.getParameter("content");
		String imgFileName = request.getParameter("category");
		String writeDate = request.getParameter("writeDate");
		
		Article avo = new Article(category, title, nickName, content, imgFileName, writeDate);
		
		try {
	        HttpSession session = request.getSession();
	        session.setAttribute("avo", avo);
			path = "boardList.jsp";
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return path;
	}//writeBoard
	
	private String updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "index.jsp";
		
		String category = request.getParameter("category");
		String title = request.getParameter("title");
		String nickName = request.getParameter("nickName");
		String content = request.getParameter("content");
		String imgFileName = request.getParameter("category");
		String writeDate = request.getParameter("writeDate");
		
		Article avo = new Article(category, title, nickName, content, imgFileName, writeDate);
		
		try {
	        HttpSession session = request.getSession();
	        session.setAttribute("avo", avo);
			path = "boardList.jsp";
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return path;
	}//updatePost
	
	private String deletePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "index.jsp";
				
		try {
	        HttpSession session = request.getSession();
	        session.invalidate();
			path = "boardList.jsp";
			
		}catch (Exception e) {
			System.out.println(e);
		}
		return path;
	}//deletePost
}// class
