package com.edu.bank.test;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankTest {

	public static void main(String[] args) {
		//james, Tomas 고객이름 생성
		Customer james = new Customer("James","Seoul");//컴파일 할 때 값이 들어감
		Customer tomas = new Customer("Tomas","Inchoen");
		
		//James, Tomas 각각의 통장 개설
		james.openAccount(new Account(123,"Toss Bank",0));
		tomas.openAccount(new Account(456,"Kakao Bank",0));
		
		//개설한 통장을 반환받아서 통장의 기능을 사용한다.
		Account jamesAccount=james.getAccount();

		//james가 1만원, 3만원을 입금하고 2만원을 출금한 잔액을 최종적으로 출력한다.(서비스요청)
		System.out.println("입금 20000 만원 >>");//
		jamesAccount.deposit(20000.0);
				
		System.out.println("입금 15000 만원 >>");
		jamesAccount.deposit(15000.0);
	
		System.out.println("출금 5000 만원 >>");
		jamesAccount.withdraw(5000.0);
		
		System.out.println("최종 잔액은 >>"+jamesAccount.getBalance()+"원");
	}
	
}
