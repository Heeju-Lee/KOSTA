package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/params",
			loadOnStartup = 1)
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public ParameterServlet() {
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
		
		//1. 한글처리..양방향
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		//2. PrintWriter
		PrintWriter out = response.getWriter();
		//3. 폼값 받아서..
			String job = request.getParameter("job");
			String pageNo = request.getParameter("pageNo");
			String searchWord = request.getParameter("searchWord");
		//4. 웹브라우저로 출력
			StringBuffer sb = new StringBuffer();
			sb.append("<h2> job : ").append(job).append("</h2>");
			sb.append("<h2> pageNo : ").append(pageNo).append("</h2>");
			sb.append("<h2> searchWord : ").append(searchWord).append("</h2>");
			
			out.println("<h1>Get방식으로 받은 정보를 출력합니다..</h1>");
			out.println(sb);
	}

	  protected void doPost(HttpServletRequest request, HttpServletResponse
	  response) throws ServletException, IOException {
	  System.out.println("3. doPost() 호출"); 
	  
		//1. 한글처리..양방향
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		//2. PrintWriter
		PrintWriter out = response.getWriter();
		//3. 폼값 받아서..
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			String[] hobby = request.getParameterValues("hobby");
			
			StringBuilder sbHobby = new StringBuilder();
			for(String h : hobby)
				sbHobby.append(h).append(" , ");
			
			sbHobby.setLength(sbHobby.length()-2);
			System.out.println(sbHobby);
			System.out.println(sbHobby.length());
			
			String favorite = request.getParameter("favorite");
			String desc = request.getParameter("desc");
		//4. 웹브라우저로 출력
			StringBuilder sb = new StringBuilder();
			sb.append("<h3> name : ").append(name).append("</h3>");
			sb.append("<h3> email : ").append(email).append("</h3>");
			sb.append("<h3> gender : ").append(gender).append("</h3>");
			sb.append("<h3> hobby : ").append(sbHobby).append("</h3>");
			sb.append("<h3> favorite : ").append(favorite).append("</h3>");
			sb.append("<h3> desc : ").append(desc).append("</h3>");
			
			
			out.println("<h1>Post방식으로 받은 정보를 출력합니다..</h1>");
			out.println(sb);
	  }
}
