package web.generic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 @ annotation 기법
 
  * <servlet>
	<servlet-name>MyGenericServlet</servlet-name>
	<servlet-class>web.generic.servlet.MyGenericServlet</servlet-class>
	</servlet>	
 
 * <servlet-mapping>
	<servlet-name>MyGenericServlet</servlet-name>
	<url-pattern>/SS</url-pattern>
	</servlet-mapping>
	
*/
@WebServlet("/SS") //서블릿주문서("호출명")
public class MyGenericServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	//public + 기본 생성자 + 인자값이 없어야 함.(container가 객체 생성하기 때문임)
   public MyGenericServlet() {
    	System.out.println("1.....서블릿 인스턴스 생성.....By Container...");
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		out.println("<html><body><h2>");
		out.println("Hello GenericServlet~~!!!");
		out.println("</h2></body></html>");
	}

}
