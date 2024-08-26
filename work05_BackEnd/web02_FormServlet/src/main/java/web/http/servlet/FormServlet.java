package web.http.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FS")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FormServlet() {
	}

	// 클라이언트의 요청이 서버상으로 들어오면 doGet() 컨테이너에 의해서 호출
	// 이때 폼에 입력된 값이 요청정보를 타고 서버로 전달된다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 폼에 입력된 값 id, pass를 받아온다. ... id, pass
		String id = request.getParameter("userId");
		String pass = request.getParameter("userPass");

		// 2. 받아온 값을 브라우저로 출력
		// * ID : KOSTA
		// * PASS : 1234
		PrintWriter out = response.getWriter();
		out.println("<html><body><h3>");
		out.println("<ul><li>ID : " + id + "</li>");
		out.println("<li>PASS : " + pass + "</li></ul>");
		out.println("</h3></body></html>");

		out.close();
	}
}
