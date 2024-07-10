package com.edu.oop.bank;

public class Customer {
	String name;
	String address;
	Account account;

	public Customer() {};
	
	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
	}

	
	public Account getAccount() {
		return account;
	}
	
	public void openAccount(Account account) {
		if(account.bankName=="KB" && account.balance<1000) {
			System.out.println(name+"님\n최초 개설 시, 잔액이 1,000원 이상이어야합니다.\n다시 시도하십시오.");
			;
		}else{
			this.account = account;
			System.out.println(name+"님의 계좌가 정상적으로 개설되었습니다.");;
			} 
				
	}	

	public String getCustomerInfo() {
		return name+", "+address+", "+account;
	}
	
}
