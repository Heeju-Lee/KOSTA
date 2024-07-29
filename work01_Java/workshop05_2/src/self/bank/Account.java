package self.bank;

public class Account {
	private int balance;

	public Account(int balance) {
		super();
		this.balance = balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void deposit(int amt) {
		if(amt<1000) {
			System.out.println("입금액은 1천원 이상이어야 합니다!!");
			return;
		}else {
			balance += amt;
		}
	}
	
	public void withdraw(int amt) {
		if(amt<=balance) {
			System.out.println("출금액이 너무 많습니다.");
			return;
		}else {
			balance -= amt;
		}
	}	

	@Override
	public String toString() {
		return "현재 잔액은 "+balance+" 원 입니다.";
	}		
}//class









