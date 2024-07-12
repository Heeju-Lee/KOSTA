package com.edu.parent;
/*
추상클래스의 용도
1. 공통의 피자를 만들어내기 위한 공통적인 작업(필드,메소드)는 그대로 자식클래스에게 물려주고
2. 반면에 서로 다른 여러종류의 피자가 만들어질 수 있는 결정적인 부분은 추상메소드로 물려준다.
	topping 에 따라서 서로다른 피자 종류가 만들어진다.
	
	인터페이스와의 차이점 :: 추상성
	완벽한 추상성 =======> interface : 사용자와 벤더 사이에 규약, 표준화
	부분적인 추상성 =======> Abstract : 자식들에 있어서 결정적인 다른 부분들은 미완으로 물려준다.(자식이 완성하도록 강제)
	
 */
public abstract class Pizza {
	protected int price;
	protected String storeName;
		
	public Pizza() {
		this(15000,"PizzaHut");
	}
	
	public Pizza(int price, String storeName) {
		super();
		this.price = price;
		this.storeName = storeName;
	}
	
	//기능을 최종적으로 추가
	
	public void sequencePizza() {
		dogh();
		topping();
		bake();
		cutting();
		boxing();
	}
	public void dogh() {
		System.out.println("피자 반죽과 함께 도우를 잘 만들어 줍니다.");
	}
	
	public void bake() {
		System.out.println("180도 오븐에서 10분간 구워냅니다.");
	}
	
	public void boxing() {
		System.out.println("잘려진 피자를 박스에 포장합니다.");
	}

	public void cutting() {
		System.out.println("피자를 8조각으로 자릅니다.");
	}
	

	public abstract void topping();
	
	public String toString() {
		return "상점이름, "+storeName+" - 가격, "+price;
	}
}

