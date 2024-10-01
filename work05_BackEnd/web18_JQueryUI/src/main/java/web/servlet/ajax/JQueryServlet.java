package web.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/front.do")
public class JQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		
		if(command.equals("subject")) {
			subject(request,response);
		}else if(command.equals("company")) {
			company(request,response);
		}
			
	}


	private void subject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = "Big Data | Python | Java OOP | JDBC&Modeling | Spring MVC ";
		
		PrintWriter out = response.getWriter();
		
		out.print(result);//ajax successFunction(result)의 인자값으로 전달			
	}

	private void company(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//DAO 리턴받고..비즈니스 로직 호출...데이터 응답
		String result = "<ul><li>Tomato System</li><br>"
				+ "<li>NCSoft coporation</li><br>"
				+ "<li>EAST System Company</li><br>"
				+ "<li>LGCNS Software</li><br>"
				+ "<li>Tomato System2</li></ul>";
	
		PrintWriter out = response.getWriter();
		
		out.print(result);//ajax successFunction(result)의 인자값으로 전달		
	}

}
