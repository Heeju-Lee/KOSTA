package broker.twotier.exception;

public class InvalidTransactionException extends Exception {
	
	public InvalidTransactionException(String message){
		super(message);
	}
	
	public InvalidTransactionException(){
		this("This is InvalidTransaction...");
	}
}
