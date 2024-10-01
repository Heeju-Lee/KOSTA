package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = "*.do", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String command = request.getParameter("command");
		//hidden값으로 들어온 요청을 받지 않고...들어온 요청의 전체 주소를 직접 받아온다....앞부분만 자른다.
		String requestURI = request.getRequestURI(); //web22_FactoryPattern/find.do
		System.out.println("RequestURI :: "+requestURI);
		
		String contextPath = request.getContextPath();
		System.out.println("ContextPath :: "+contextPath);//web22_FactoryPattern
		
		String command = requestURI.substring(contextPath.length()+1);//   /find.do, find.do
		System.out.println("Command "+command);
		
		String path = "index.jsp";
		ModelAndView mv = null;
		
		Controller controller   = HandlerMapping.getInstance().createController(command);
		
		try {
			mv = controller.execute(request, response);
			path = mv.getPath();
			
		}catch(Exception e) {			
		}
		if(mv!=null) {
			if(mv.isRedirect()) response.sendRedirect(path);
			else request.getRequestDispatcher(path).forward(request, response);
		}		
	}
}


















