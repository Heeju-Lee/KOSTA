package com.edu.oop.bank;

public class Account {
	int accNumber;
	String bankName;
	double balance;
	
	//기본 생성자
	public Account(){};
		
	//생성자 주입
	public Account(int accNumber, String bankName, double balance) {
		this.accNumber = accNumber;
		this.bankName = bankName;
		this.balance = balance;
	}

	public int getAccNumber() {
		return accNumber;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void withdraw(double amt) {
		if(balance-amt<0) {
			System.out.println("인출액이 잔액보다 클 수 없습니다.\n다시 시도하십시오.");
		;			
		}else {
			balance -= amt;
			System.out.println("출금이 정상적으로 처리되었습니다.");
		}
	}
	
	public void deposit(double amt) {
		if(amt<0) {
			System.out.println("입금액이 0보다 작을 수 없습니다.\n다시 시도하십시오.");	
		}else {
			balance += amt;
			System.out.println("입금이 정상적으로 처리되었습니다.");
		}
	}	
	public String getAccountInfo() {
		return "계좌번호:"+accNumber+"\n은행명"+bankName+"\n잔액:"+balance;
	}
	
}
