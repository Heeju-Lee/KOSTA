package com.edu.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.edu.repository.ProductRepository;
import com.edu.repository.UserRepository;
import com.edu.service.LoginService;
import com.edu.service.ProductService;
import com.edu.service.UserService;
import com.edu.vo.AirConditioner;
import com.edu.vo.MyDate;
import com.edu.vo.NoteBook;
import com.edu.vo.Product;
import com.edu.vo.Refrigerator;
import com.edu.vo.User;

public class projectTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 더미 사용자 데이터 생성
        HashMap<String, User> users = new HashMap<>();
        Map<Integer, Product> products = new HashMap<>();
        UserRepository userRepository = new UserRepository();
        ProductRepository productRepository = new ProductRepository();

//        users.put("user1", new User("user1", "password1", "John Doe", new MyDate(1988,7,12)));
//        users.put("user2", new User("user2", "password2", "Jane Smith", new MyDate(2000,9,22)));
//        users.put("user3", new User("user3", "password3", "James", new MyDate(1970,3,5)));
//        users.put("user4", new User("user4", "password4", "Bob", new MyDate(1996,12,11)));
//       
//        products.put(1, new Refrigerator("슈퍼냉장고", 40000, "냉장고중에서 최고 냉장고입니다." , "Refrigerator", 100));
//        products.put(2, new NoteBook("맥북m2프로", 20000, "애플에서 만든 좋은 노트북입니다." , "NoteBook", "Apple"));
//        products.put(3, new AirConditioner("벽걸이에어컨", 30000, "냉장고중에서 최고 냉장고입니다." , "AirConditioner", true));
//        products.put(4, new Refrigerator("허접냉장고", 40000, "냉장고중에서 최고 냉장고입니다." , "Refrigerator", 100));
        
        // 유저DB, 상품DB에 값 저장
        userRepository.setHashMap(users);
        productRepository.setHashMap(products);
        
        // 저장이 잘 되었는가 테스트
        for (String key : userRepository.getHashMap().keySet()) {
        	System.out.println(userRepository.getHashMap().get(key));
        }
        
        for (Integer key : productRepository.getHashMap().keySet()) {
        	System.out.println(productRepository.getHashMap().get(key));
        }
        
        // ================== LoginService 테스트 진행 ==================
        LoginService loginService = new LoginService(userRepository);

        System.out.println(">>>>>>>>>>>> Orange Market에 오신걸 환영합니다~~~~~~~~~~~~~~~~~~~!\n");
        while (true) {
            System.out.println("================= 서비스 이용을 위해 로그인을 해주세요. =================");
            System.out.println(" 1. 로그인   | 2. 회원가입   | 3. 아이디 찾기 | 4. 패스워드 찾기 | 0. 종료  ");
            System.out.println("==============================================================");

            int number = sc.nextInt();

            switch (number) {
            	case 0:
            		System.out.println("프로그램을 종료합니다.");
            		sc.close();
            		return;
                case 1:
                    System.out.print("ID : ");
                    String id = sc.next();
                    System.out.print("PW : ");
                    String password = sc.next();
                    loginService.login(id, password);
                    break;
                case 2:
                    System.out.println("=========== 회원가입을 위해 아래 정보를 입력해주세요. ===========");
                    String addId;
                    String addPw;
                    
                    while (true) {
                    	System.out.println("ID");
                    	addId = sc.next();
                    	if(userRepository.getHashMap().containsKey(addId)) {
                    		System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
                    	} 
                    	if(!(userRepository.getHashMap().containsKey(addId))) {
                    		System.out.println("사용가능한 아이디입니다.");
                    		break;
                    	}
                    }
                    while (true) {
                    	int minLength = 5;
                    	int maxLength = 12;
                    	
                    	System.out.println("Password *비밀번호는 5자이상 12자이하, @, /, #을 제외하여 입력해주십시오.");
                    	addPw= sc.next();
                    	if((addPw.length()>=maxLength || addPw.length()<=minLength)) {
                    		System.out.println("비밀번호는 5자이상 12자이하로 입력해주십시오.");
                    	} 
                    	else if(addPw.contains("@")|| addPw.contains("/")||addPw.contains("#")) {
                    		System.out.println("비밀번호는 @, /, #을 제외하고 입력해주십시오.");
                    	}
                    	else break;
                    }
                    System.out.println("이름");
                    String name = sc.next();
	                
                    System.out.println("생년월일 *반드시 yyyy-mm-dd 형식으로 입력해주십시오.");
                    MyDate date = null;
                    while (true) {
	                    String dateStr = sc.next();
	                    try{
	                    	date = MyDate.inputSc(dateStr);
	                    	break;
	                    }catch(IllegalArgumentException error){
	                    	System.out.println(error.getMessage());//예외처리
	                    }
                    }
                    
                    System.out.println("이메일		 ex)orange@market.com");
                    String email = sc.next();
                    System.out.println("주소 		 ex)과일특별시 오렌지구");
                    String address = sc.next();
                    System.out.println("휴대폰 번호  ex)하이픈'-'을 제외하고 입력해주십시오.");
                    String phoneNumber = sc.next();
	
                    User addUser = new User(addId, addPw, name, date, email, address, phoneNumber);
                    loginService.register(addUser);
                    break;

                case 3: 
                    System.out.println("=========== 아이디 찾기 ===========");
                    System.out.println(">>>> 아래 정보를 입력해주세요.");
                    System.out.print("이름 : ");
                    String userName = sc.next();
                    System.out.print("휴대폰 번호  ex)하이픈'-'을 제외하고 입력해주십시오.");
                    String userPhoneNumber = sc.next();
                    loginService.findId(userName, userPhoneNumber);
                    break;
                    
                case 4: 
                    System.out.println("=========== 패스워드 찾기 ===========");
                    System.out.println(">>>> 아래 정보를 입력해주세요.");
                    System.out.print("ID : ");
                    String userId = sc.next();
                    System.out.print("이름 : ");
                    String userName1 = sc.next();
                    loginService.findPw(userId, userName1);
                    break;
             
                default:
                    System.out.println("잘못된 요청입니다. 번호를 다시 입력해주세요.\n");
                    break;
            }
        }
    }
}
        
        // ================== UserService 테스트 진행 ==================
        //UserService userService = new UserService();
        
        
        
        
        
        
        // ================== ProductService 테스트 진행 ==================
        //ProductService productService = new ProductService();





