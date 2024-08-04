package broker.twotier.exception;

public class DuplicateSSNException extends Exception {
	
	public DuplicateSSNException(String message){
		super(message);
	}
	
	DuplicateSSNException(){
		this("This is DuplicatioeSSN...");
	}

}
