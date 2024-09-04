package controller;

public class ControllerFactory {
	private static ControllerFactory factory = new ControllerFactory();
	private ControllerFactory() {}
	public static ControllerFactory getFactory() {
		return factory;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("REGISTER")) {
			controller = RegisterController.getInstance();
			System.out.println("RegisterController...Creating...OK");
			
		}else if(command.equals("LOGIN")) {
			controller = LoginController.getInstance();
			System.out.println("LoginController...Creating...OK");
			
		}else if(command.equals("FIND")) {
			controller = FindController.getInstance();
			System.out.println("FindController...Creating...OK");
			
		}else if(command.equals("DELETE")) {
			controller = RemoveController.getInstance();
			System.out.println("RemoveController...Creating...OK");
		}
		
		return controller;
	}
}
	
