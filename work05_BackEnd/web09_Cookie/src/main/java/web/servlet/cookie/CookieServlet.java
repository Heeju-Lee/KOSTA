package web.servlet.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 쿠키 생성
			Cookie c1 = new Cookie("id","kosta");
			Cookie c2 = new Cookie("today","2024-08-29");
					
		//쿠키 정보 저장 시간을 지정
			c1.setMaxAge(24*60*60);//하루동안 저장
			c2.setMaxAge(24*60*60*2);//이틀동안 저장			
			
			
		// 2. 클라이언트로 보냄
			response.addCookie(c1);
			response.addCookie(c2);
			
		//페이지 이동
			response.sendRedirect("getCookie.jsp");
	}
}
