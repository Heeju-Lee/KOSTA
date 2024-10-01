package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

/*
 * Component란?
 * 인터페이스 기반으로 작성된 재사용성 강한 자바 클래스
 * 폼값 받아서 
 * DAO 리턴받고 비지니스 로직 호출...데이타 반환
 * 바인딩
 * 네비게이션
*/
public class FindController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		return new ModelAndView(path);
	}
}
