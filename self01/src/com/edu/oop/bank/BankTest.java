package com.edu.oop.bank;

import java.util.Scanner;

public class BankTest {

	public static void main(String[] args) {
		
		Customer james = new Customer("James","NY");
		Customer tomas = new Customer("Tomas","LA");
		
		james.openAccount(new Account(123, "KB", 1000));
		tomas.openAccount(new Account(456, "toss", 0));
		
		Account jamesAccount=james.getAccount();
		Scanner input = new Scanner(System.in);
		
		System.out.println("입금, 출금, 나가기 중 입력해주십시오.");
		String WorD =input.next();
		
			while(!WorD.equals("나가기")) {
				if(WorD.equals("입금")) {
					System.out.println("입금하실 금액을 입력하십시오.");
					double Deposit =input.nextDouble();
					jamesAccount.deposit(Deposit);
					
					System.out.println("현재 잔액>>"+jamesAccount.balance);
					
					System.out.println("계속하시겠습니까? 예/아니오");
					String WorD1 =input.next();
					if(!WorD1.equals("예")){
						System.out.println("종료합니다. 안녕히 가십시오.");
						System.exit(0)
						;
					}
					//System.out.println("입금 후 잔액"+jamesAccount.balance);	
				}else if (WorD.equals("출금")) {  
					System.out.println("출금하실 금액을 입력하십시오.");
					double Withdraw =input.nextDouble();
					jamesAccount.withdraw(Withdraw);
						
					System.out.println("현재 잔액>>"+jamesAccount.balance);
					//System.out.println("출금 후 잔액"+jamesAccount.balance);
					System.out.println("계속하시겠습니까? 예/아니오");
					String WorD2 =input.next();
					if(!WorD2.equals("예")){
						System.out.println("종료합니다. 안녕히 가십시오.");
						System.exit(0);
					}
				}else {
					System.out.println("잘못된 값을 입력하셨습니다.");
					break;}
			}
	}
}
				

		

	
