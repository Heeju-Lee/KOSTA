package web.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

@WebServlet("/front.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성...한글처리 안해도 된다....filter 등록되어져 있음
		//command 값 받아온다.
		String command = request.getParameter("command");
		String path = "index.html";
				
		if(command.equals("find")) {
			path = find(request, response);
		}else if(command.equals("login")) {
			path = login(request, response);			
		}else if(command.equals("register")) {
			path = register(request, response);
		}else if(command.equals("showAll")) {
			path = showAll(request, response);
		}else if(command.equals("logout")) {
			path = logout(request, response);
		}else if(command.equals("idCheck")) {
			path = idCheck(request, response);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}//doProcess

	private String idCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		//폼값 받아서
		String id = request.getParameter("userId");//data: {'userId':userId},
		//비즈니스 로직 호출...true / false...boolean idExist()
		try {
			boolean find = MemberDAOImpl.getInstance().idExist(id);
			request.setAttribute("find", find);
			
			return "idCheck_result.jsp";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "idCheck_result.jsp";
	}
	
	
	private String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		return path;
	}
	
	private String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String path = "find_fail.jsp";//프로그램에서 default path는 실패했을경우

		try {
			// 2. DAO리턴받고, 비즈니스 로직을 호출한다.
			Member rvo = MemberDAOImpl.getInstance().findByIdMember(id);
			if (rvo != null) {
				// 3. 반환값 바인딩
				request.setAttribute("vo", rvo);
				path = "find_ok.jsp";//path라는 변수를 생성해 방향만 바꿔줌.
			}
		} catch (SQLException e) {

		}
		return path;
	}
	
	private String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		return path;
	}
	
	private String register(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id").trim();
		String password = request.getParameter("password").trim();
		String name = request.getParameter("name").trim();
		String address = request.getParameter("address").trim();
		Member pvo = null;
		String path = "index.html";
		
		if(name.equals("")||address.equals("")) {
			pvo = new Member(id,password);
		}else {
			pvo = new Member(id,password,name,address);
		}

		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			path = "register_result.jsp";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return path;
	}
	
	private String showAll(HttpServletRequest request, HttpServletResponse response) {
		String path = "allView.jsp";
		
		try {
			ArrayList<Member> list= MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("list", list);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return path;
	}

}
