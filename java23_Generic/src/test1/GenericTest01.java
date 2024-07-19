package test1;

//Generic 사용 안함.
//box에 뭐든지 담을 수 있도록 설계했을 때의 상황

/*
 * 1. 뭐든지 담긴다.
 * 2. 꺼낼때마다 Object Casting을 해줘야한다.
 */
class Box{
	Object content; //----> box에 뭐든지 담을 수 있기 위해서는 ? object 타입
	
	public Object selectContent() {//box에 들어있는 내용물을 꺼내는 함수 
		return content;
	}
}

public class GenericTest01 {

	public static void main(String[] args) {
		Box box = new Box();
		box.content = "곰돌이인형";
		
		String bearDoor=(String)box.selectContent();
		System.out.println("박스안의 내용물을 .... "+bearDoor);
	}
}
