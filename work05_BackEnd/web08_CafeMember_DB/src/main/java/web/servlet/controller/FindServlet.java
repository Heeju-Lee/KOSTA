package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

@WebServlet("/Find")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get방식 요청을 처리....
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post방식 요청을 처리....
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로직은 여기서 작성....
		/*
		 * 0. 한글처리 양방향 1. 폼값을 받아서 2. DAO리턴받고, 비즈니스 로직을 호출한다. 3. 반환값 바인딩 4. 네비게이션
		 */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 1. 폼값을 받아서
		String id = request.getParameter("id");
		String path = "find_fail.jsp";//프로그램에서 default path는 실패했을경우

		try {
			// 2. DAO리턴받고, 비즈니스 로직을 호출한다.
			Member rvo = MemberDAOImpl.getInstance().findByIdMember(id);
			if (rvo != null) {
				// 3. 반환값 바인딩
				request.setAttribute("vo", rvo);
				path = "find_ok.jsp";//path라는 변수를 생성해 방향만 바꿔줌.
			}
		} catch (SQLException e) {

		}
		request.getRequestDispatcher(path).forward(request, response);
	}
}
