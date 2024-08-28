package web.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginError")
public class LoginError extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
    	PrintWriter out = response.getWriter();
    	
    	out.println("<head>");
		out.println("<style>");
		out.println("* { text-align: center; }");
		out.println("p { margin-top: 30px; margin-bottom: 50px; }");
		out.println("a { display: block; line-height: 2; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p><h2>로그인 실패!!</h2></p>");		
		out.println("<a>로그인 다시 하기</a");
		out.println("</body>");
	}

}
