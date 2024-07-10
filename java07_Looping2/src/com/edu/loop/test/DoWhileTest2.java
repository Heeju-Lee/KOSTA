package com.edu.loop.test;

import java.util.Scanner;

import com.edu.loop.service.Service;

public class DoWhileTest2 {
/*
Application을 작성하기 위한 Looping문
*/

	public static void main(String[] args) {
		//키보드로 값을 읽어들이는 Scanner...실행시점
		Scanner sc = new Scanner(System.in);
		Service service = new Service();//메모리에 올라간다....기능을 호출
		
		do {
			System.out.println("원하는 메뉴를 선택하세요.");
			System.out.println("1. 계좌 개설 \t2. 고객정보 조회\t3. 종료");
			
			int menu = sc.nextInt();
			switch(menu) {
			case 1:
				service.openAccount();
				//System.out.println("계좌 개설 서비스 기능이 진행됩니다.");
				break;
			case 2:
				System.out.println(service.getCustomInformation());//Service class에서 return만 하기 때문에 print해줘야 함.
				//System.out.println("고객정보 조회 기능이 진행됩니다.");
				break;
			case 3:
				System.out.println("종료되었습니다.");
				System.exit(0);
				break;
			}//switch문
			
		}while(true);//빠져나와서 do 반복
		
	}
	
}
