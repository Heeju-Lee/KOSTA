package web.servlet.greet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetServlet extends HttpServlet{

	private String greet = "";//ready on 시점에 값을 받아옴.. 클라이언트 요청과는 무관
	private String name = "";//클라이언트 요청시에 폼값...
	
	public GreetServlet(){
		System.out.println("1.....서블릿 생성.....");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("2.....ServletConfig 생성....intit() 호출");
		
		 greet = getInitParameter("GREET");
		 System.out.println("greet message :: "+greet);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. 클라이언트 요청시 호출... 폼값을 받아온다....");
		
		PrintWriter out = response.getWriter();
		name = request.getParameter("name");// 필드초기화
		
		out.println("<html><body><h3>");
		out.println(name+", "+greet);
		out.println("</h3></body></html>");
		
		out.close();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response); // GET 요청을 POST 처리 메서드로 전달
	}
	
}

