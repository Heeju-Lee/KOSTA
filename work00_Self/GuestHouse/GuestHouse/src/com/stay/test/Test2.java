package com.stay.test;

import com.stay.dao.ReserveDao2;
import com.stay.exception.DMLException;
import com.stay.exception.RecordNotFoundException;
import com.stay.vo.Customer;

import java.util.Scanner;

public class Test2 {
	public static Scanner sc = new Scanner(System.in);
	public static ReserveDao2 dao = ReserveDao2.getInstance();
	
	public static void main(String[] args) {
		//dao.delete("C001");
		

		String loginId = "";

		// 초기 화면 
		while (true) {
			
			// 로그인 
			loop:
			while (true) {
				loginId = Login();
                
                //userId 값이 반환 되면 로그인 서비스를 종료
                if (loginId.equals("fail")) 
                    continue;

				// 메인메뉴
				while (true) {
					System.out.println("\n======== 메인 메뉴 ========");
					System.out.println("[1]지역선택   [2]예약하기   [3]마이페이지   [0]로그아웃");
					System.out.print("번호를 선택하세요 : ");
					
					int menu = sc.nextInt();
					System.out.println();

					switch (menu) {
					case 1:						
						selectLocation();
						break;
					case 2:
						// 예약하기
						selectReservation(loginId);
						break;
					case 3:
						// 마이페이지
						if(selectMypage(loginId) ) break loop;
						else break;
					case 0:
						// 로그아웃
						loginId = "fail";
						System.out.println("로그아웃 되셨습니다.");
						break;
						
					default:
						System.out.println("유효하지않은 번호입니다. 다시 입력해주세요.");
					}

					if (loginId.equals("fail"))
						break;
				}
			}
		}

	}
	
	// 지역 선택하기 
	static void selectLocation() { 
		// 지역선택
		System.out.println("\n======== 지역 선택 메뉴 ========");
		System.out.println("[1]서울특별시   [2]강원도   [3]부산   [0]메인돌아가기");
		System.out.print("번호를 입력하세요 : ");
		int num = sc.nextInt();
		
		String location = ""; 
		if(num != 0) {
			if(num == 1) location = "서울특별시";
			else if(num == 2 ) location = "강원도";
			else if(num == 3) location="부산";
			
			search(location);
		}

	}
	// 검색 기능
	static void search(String location) {
		System.out.println("\n======== 검색 선택 메뉴 ========");
		System.out.println("[1] 최저가격 조회\n" +
							"[2] 평점 상위 10%조회\n" +
							"[3] 가격범위 조회\n" +
							"[4] 예약 가능 숙소 조회\n" +
							"[5] 리뷰 많은 순 조회\n" +
							"[6] 전월 대비 가격인하율이 높은순 조회\n"
							);
		
		System.out.print("번호를 입력하세요 : ");
		int optionNum = sc.nextInt();
		
		switch(optionNum) {
			case 1:
				// 최저가격 조회 
				dao.findByMinPrice(location).forEach(System.out::println);
				break;
				
			case 2:
				// 평점 상위 10%조회
				dao.findByTopTenPercent(location).forEach(i-> System.out.println(i.includeRating()));
				break;
				
			case 3:
				// 가격범위 조회 
				System.out.print("최저가격을 입력하세요.");
				int minPrice = sc.nextInt();
				System.out.print("최고가격을 입력하세요.");
				int maxPrice = sc.nextInt();
				dao.findByPrice(location, minPrice, maxPrice).forEach(System.out::println);
				break;
				
			case 4:
				// 예약 가능 숙소 조회
				System.out.print("체크인 날짜를 입력하세요 (2024-08-30 형식으로 입력하세요): ");
				String startdate = sc.next();

				System.out.print("체크아웃 날짜를 입력하세요 (2024-08-30 형식으로 입력하세요): ");
				String enddate = sc.next();


				dao.findByReservable(location, startdate, enddate).forEach(System.out::println);
				
				break;
				
			case 5:
				// 리뷰 많은 순 조회
				dao.findByReviewCount(location).forEach(System.out::println);
				break;
				
			case 6:
				// 전월 대비 가격인하율이 높은순 조회
				dao.findByLeadMonth(location).forEach(System.out::println);
				break;
				
			default:
				System.out.println("유효하지않은 번호입니다. 다시 입력해주세요.");
		}
	}
	
	// 예약하기
	static void selectReservation(String loginId) {
		System.out.println("\n======== 예약하기 ========");
		System.out.print("게스트하우스 번호를 입력하세요 : ");
		String guestHouseId = sc.next();
		
		System.out.print("방 번호를 입력하세요 : ");
		int roomId = sc.nextInt();
		
		System.out.print("체크인 날짜를 입력하세요 (2024-08-30 형식으로 입력하세요): ");
		String startdate = sc.next();

		System.out.print("체크아웃 날짜를 입력하세요 (2024-08-30 형식으로 입력하세요): ");
		String enddate = sc.next();

		//2024-08-30
		dao.reservation(startdate,enddate, guestHouseId, roomId, loginId);

	}
	
	// 마이페이지
	static boolean selectMypage(String loginId) {
		System.out.println("\n======== 마이페이지 ========");
		System.out.println("[1]예약내역 확인   [2]예약취소   [3]회원정보수정   [4]회원탈퇴   [0]메인으로 돌아가기");
		System.out.print("번호를 선택하세요 : ");
		int num = sc.nextInt();
		
		switch(num) {
			case 1:
				// 예약 내역 조회
				dao.findMyReservation(loginId).forEach(System.out::println);
				break;
				
			case 2:
				// 예약취소 
				System.out.print("취소할 게스트하우스의 이름을 입력하세요 : ");
				String house_id = sc.next();
				System.out.print("취소할 게스트하우스의 방 번호를 입력하세요 : ");
				int room_num = sc.nextInt();
				System.out.print("취소할 예약의 시작 날짜를 입력하세요 (2024-08-30 형식으로 입력하세요) : ");
				String start_date = sc.next();
				System.out.print("취소할 예약의 끝 날짜를 입력하세요 (2024-08-30 형식으로 입력하세요) : ");
				String end_date = sc.next();

				dao.cancelReservation(house_id, room_num, loginId, start_date, end_date);
				break;
			case 3: 
				System.out.print("수정할 패스워드를 입력하세요 : ");
				String password = sc.next();
				
				System.out.print("핸드폰 번호를 입력하세요 (010-XXXX-XXXX 형식으로 입력하세요) : ");
				String phoneNumber = sc.next();
				
				dao.update(new Customer(loginId, password, phoneNumber));
				
				break;
				
			case 4:
				// 회원탈퇴
				dao.delete(loginId);
				return true;
				
			case 0:
				break;
				
			default:
				System.out.println("유효하지않은 번호입니다. 다시 입력해주세요.");
		}
		
		return false;
	}
	
	static void SignUp() {
		System.out.println("\n======== 회원가입 ========");
		System.out.print("아이디를 입력하세요 : ");
		String id = sc.next();
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();
		
		System.out.print("비밀번호를 입력하세요 : ");
		String password = sc.next();
		
		System.out.print("핸드폰번호를 입력하세요 : ");
		String phoneNumber = sc.next();
		
		dao.create(new Customer(id, name, password, phoneNumber));
	}
	
	// 로그인
	static String Login() {
		System.out.println("\n======== 로그인 ========");
		System.out.print("아이디를 입력하세요 : ");
		String id = sc.next();
		System.out.print("비밀번호를 입력하세요 : ");
		String password = sc.next();
		
		// 로그인 정보 입력 
		try {
			return dao.login(id, password);
			
		}catch(RecordNotFoundException | DMLException e) {
			System.out.println(e.getMessage());
		}
		
		return "fail";
	}
}
