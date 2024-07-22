package step1;

@FunctionalInterface
interface Attackable{
	void attack();//인자값 없고 | 반환타입 없고
}

@FunctionalInterface
interface Moveable{
	void move(int right, int left);//인자값 2개 | 반환타입은 없다. 
}

class Fighter{
	//method overloading
	public void action(Attackable a) {
		a.attack();
	}
	public void action(Moveable m) {
		m.move(10,20);
	}
}

public class LambdaTest5{

	public static void main(String[] args) {
		Fighter fighter = new Fighter();
		
		// 실행문이 하나일 때...
		fighter.action(()->System.out.println("드론을 이용해서 공중공격 합니다."));
		
		// 실행문이 두개일 때...
		fighter.action(()->{
			System.out.println("드론을 이용해서 공중공격 합니다.");
			System.out.println("주요 건물을 타겟으로 방어전선을 구축 공격을 개시합니다.");
		});
		System.out.println("=====================================");
		// 2...moveable을 람다식으로 구현
		//오른쪽으로 1000km 이동합니다.
		//왼쪽으로 40km 이동합니다.
		fighter.action((x,y)->{
			int right = x * 100;
			int left = y +20;
			System.out.println("오른쪽으로 "+right+"km 이동합니다.");
			System.out.println("왼쪽으로 "+left+"km 이동합니다.");
		});
	}
}


