package client;

import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ControllerFactory;

public class FrontServlet {
		static HttpServletRequest request = null;
		static HttpServletResponse response = null;

	public static void main(String[] args) {
		//폼으로 받은 값으로 생각한다....
		Scanner sc = new Scanner(System.in);
		System.out.println(">>> command 값 입력");
		
		String command = sc.next();
		
		//1.
		Controller controller = ControllerFactory.getFactory().createController(command);
		
		//2.
		String path = controller.handle(request, response);
		
		//3. 
		System.out.println(path);
		
		
	}

}
