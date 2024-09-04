package web.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algo.Count;
import com.algo.Kickboard;

@WebServlet("/front.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if(command.equals("count")) {
			wordCount(request, response);
		}else if(command.equals("kickboard")) {
			kickBoardCount(request, response);
		}
	}//
	
	private void wordCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
	}
	
	private void kickBoardCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		
	}

}










