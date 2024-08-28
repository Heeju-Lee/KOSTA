package web.servlet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Product;

@WebServlet("/List")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArrayList<Product> list = null;

    public ListServlet() {
    	list = new ArrayList<Product>();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DAO 호출 = 값을 받아온다.(DB가 없으니 값을 넣어줬음)
		Product p1 = new Product("1", "AAA", 450000, "A++");
		Product p2 = new Product("2", "BBB", 98000, "B++");
		Product p3 = new Product("3", "CCC", 56000, "C++");
		
		list.add(p1);		list.add(p2);		list.add(p3);
		
		//바인딩
		request.setAttribute("list", list);
		//네비게이션
		request.getRequestDispatcher("list.jsp").forward(request, response);		
	}
}
