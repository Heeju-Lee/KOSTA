package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

public class RegisterController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id").trim();
		String password = request.getParameter("password").trim();
		String name = request.getParameter("name").trim();
		String address = request.getParameter("address").trim();
		Member pvo = null;
		String path = "index.html";
		
		if(name.equals("")||address.equals("")) {
			pvo = new Member(id,password);
		}else {
			pvo = new Member(id,password,name,address);
		}

		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			path = "register_result.jsp";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return new ModelAndView(path);
	}
}
