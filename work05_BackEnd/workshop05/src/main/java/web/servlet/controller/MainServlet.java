package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Product;
import web.servlet.model.ProductDAOImpl;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MainServlet() {
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//폼값 받아서
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String desc = request.getParameter("desc");
		
		Product pvo = new Product(name, price, desc);
		String path = "index.html";

		try {
			ProductDAOImpl.getInstance().registerProduct(pvo);
			
			response.sendRedirect("List");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}