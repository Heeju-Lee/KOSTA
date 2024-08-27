package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/LifeCycle",
			loadOnStartup = 1)
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifeCycleServlet() {
    	System.out.println("1. LifeCycleServlet 호출");
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("2. init() 호출");
	}

	public void destroy() {
		System.out.println("4. destroy() 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. doGet() 호출");
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("<h2>안녕하세요, LifeCycleServlet 입니다.</h2>");
		out.println("</body></html>");	
		
		out.close();
	}

	  protected void doPost(HttpServletRequest request, HttpServletResponse
	  response) throws ServletException, IOException {
	  System.out.println("3. doPost() 호출"); 
	  
	  response.setContentType("text/html;charset=UTF-8");
	  
	  PrintWriter out = response.getWriter();

	  out.println("<html><body>");
	  out.println("<h2>안녕하세요, LifeCycleServlet 입니다.</h2>");
	  out.println("</body></html>"); }
	 
}
