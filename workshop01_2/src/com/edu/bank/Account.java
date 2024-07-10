package com.edu.bank;

public class Account {

	/*생성자의 balance
	 * 통장을 개설할 때 잔액이 함께 주입
	 * 은행에 따라서 이 부분의 정책이 다른다.
	 * ex)toss--->잔액이 0원이어도 개설
	 * 	  kb--->잔액이 1만원 이상일 때만 통장이 개설 
	 */
	public int accNumber;
	public String bankName;
	public double balance;
	
	public Account() {};

	public Account(int accNumber, String bankName, double balance) {
		if(bankName.equals("KB"))
			if(balance >=10000) {
			this.accNumber = accNumber;
			this.bankName = bankName;
			this.balance = balance;	
			System.out.println("KB 계좌 개설 완료");
			} else {
				this.bankName=null;
				System.out.println("KB 계좌 개설 실패");	
		} else {
			this.accNumber = accNumber;
			this.bankName = bankName;
			this.balance = balance;
			System.out.println("Bank 계좌 개설 완료");
		}
}
	public int getAccNumber() {
		return accNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double getBalance() {		
		return balance;
	}	

	/*
	 *  deposit
	 *  1000원이상만 입금 가능
	 *  "입금액은 1,000원 이상이어야 합니다."를 출력
	 *  다시 deposit을 호출할 수 있도록 되돌리기.
	 */
	public void deposit(double amt) {
		if(amt>=1000) {
			balance += amt;	
		}else System.out.println("입금액은 1천원 이상부터입니다.");
		 return;
	}
	/*
	 *  withdraw에서는 잔액 이하만 출금 가능
	 *  "출금액은 잔액보다 적어야 합니다."를 출력
	 *  다시 deposit을 호출할 수 있도록 되돌리기.
	 */
	public void withdraw(double amt) {
		if(amt<=balance) {
			balance -= amt;
		}else System.out.println("출금액은 잔액보다 더 많을 수 없습니다.");
		 return;
	}

	public String getAccountInfo() {
		return accNumber+", "+bankName+", "+balance;
	}

}
