package web.servlet.controller;

//component를 생성하는 일종의 공장
//서블릿이 전해주는 command값에 따라서 component를 생성한다.
//그리고 다시 서블릿에게 생성한 component를 반환할 때는 controller 인터페이스 타입으로 반환
//factory의 역할을 component 명으로
public class HandlerMapping {

	//싱글톤
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getFactory() {
		return factory;
	}
	
	//component를 생성하는 기능....
	public Controller createComponent(String command) {
		Controller controller = null;
		
		if(command.equals("find.do")) {
			controller = new FindController();
			System.out.println("FindController...생성됨...");
		}
		return controller;
	}	
}
