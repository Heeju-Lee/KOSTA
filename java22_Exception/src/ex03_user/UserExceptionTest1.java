package ex03_user;

class Boom extends Exception{

		Boom(){
			this("This is Boom Exception");
		}
		Boom(String message){
			super(message);
		}
	
}

class User{
	public void calc(int x, int y) throws Boom{//임의의 값 x, y가 인자값....
		System.out.println("2. calc 함수 호출....");		
		if(x==0) 
		//ArithmeticException을 발생시킬거다..
		throw new Boom("x는 0이면 안돼요. x는 분모가 될 숫자거든요.");	
		
		//연산이 진행.....y/x
		System.out.println("3. calc 함수 호출....x는 0이 아닙니다.");	

	}
}

public class UserExceptionTest1 {
	public static void main(String[] args) {
		System.out.println("1. User 객체 생성....");
		User user = new User();
		try { 
		user.calc(1, 10);
		}catch(Boom e) {
			System.out.println(e.getMessage());
		}
		System.out.println("4. 폭탄 처리 성공");
	}	

}
