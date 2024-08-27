package web.servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*Lazy Loading 
Ready On 상태의 작업들이 첫번째 클라이언트가 요청하면 그때 함께 동작한다.

PreLoading
Ready On상태의 작업들이 클라이언트 요청하기 전에 미리 메모리에 올라가서 setting되어져 있다.
이렇게 작업이 진행되기 위해서는 주문서에 옵션을 추가해야 한다.

<load-on-startup> 1 </load-on-startup>
*/

@WebServlet(urlPatterns = {"/Life"}, loadOnStartup = 1)//PreLoading 설정
public class LifeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//필드 추가
	private int count = 0;
	
	
    public LifeServlet() {
    	System.out.println("1. 서블릿 인스턴스 생성....");
    }

	public void init() throws ServletException {
    	System.out.println("2. init() 메소드 호출....by container...");
	}

	public void destroy() {
    	System.out.println("4. destory() 메소드 호출....by container...");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("3. doGet() 메소드 호출....by container...");
    	//클라이언트의 요청을 처리...
    	PrintWriter out = response.getWriter();
    	out.println("<html><body bgcolor=yellow>");
    	out.println("<h3>LifeCycle CallBack Method...</h3>");
    	out.println("<b>Count :: "+ ++count+ "</b>"); 
    	out.println("</body></html>");
    	
    	out.close();
	}

}
