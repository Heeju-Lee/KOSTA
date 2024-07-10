package com.edu.test;

import java.util.Scanner;
//사용하려면 import

public class BackMenuTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		Customer newCustomer = null;
		
		do {
			System.out.println("1. 고객 생성 2.계좌 개설 3.입금 4.출금 5.잔액조회 6.고객정보조회 7.종료");
			int menu = sc.nextInt();
				switch (menu) {
				case 1 :		
					System.out.print("이름 : ");
					String name = sc.next(); 
					System.out.print("주소 : ");
					String address = sc.next();
					newCustomer = new Customer(name, address);
				case 2 :		
					System.out.print("계좌번호를 입력하세요:");
					int AccNumber = sc.nextInt();
					System.out.print("은행명을 입력하세요:");
					String BankName = sc.next();
					System.out.print("잔액을 입력하세요:");
					double Balance =sc.nextDouble();
					newCustomer.openAccount(new Account(AccNumber,BankName,Balance));
					
					if(newCustomer.getAccount().getBankName()==null)
					System.out.println("KB국민은행 통장 개설에 실패했습니다.");
					break;
					
				case 3 : 
					System.out.print("입금액을 입력하세요: ");
					double deposit = sc.nextDouble();
					newCustomer.getAccount().deposit(deposit);
					break;
					
				case 4 : 
					System.out.print("출금액을 입력하세요: ");
					double withdraw = sc.nextDouble();
					newCustomer.getAccount().withdraw(withdraw);
					break;
					
			    case 5:
			    	System.out.println("잔액 : " + newCustomer.getAccount().getBalance());
			    	break;
			    case 6:
			    	System.out.println(newCustomer.getCustomerInfo());
			    	break;
			    	
			    case 7: 
				    System.out.println("프로그램 종료");
				    System.exit(0);
				}//switch END
		}while(true);
	}
}
				


