package self.bank;

public class Account {
	private int balance;

	public Account() {}

	public Account(int balance) {
		this.balance = balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int getBlance() {
		return balance;
	}
	
	public void deposit(int amt) {
		balance += amt;
	}
	
	public void withdraw(int amt) {  
		balance -= amt;
	}
	
	public String toString() {
		return "현재 고객님 계좌의 잔액은 "+balance+"원입니다.";
	}
}//class
