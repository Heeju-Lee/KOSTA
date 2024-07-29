package com.edu.array.test;

class Contact{
	String name;
	//생성자 주입
	public Contact(String name) {
		this.name = name;
	}
	
	public void printName() {
		System.out.println(name+"....print!!");
	}
}

class ContactService{
	public void sendMessage(String msg) {
		//Bob's Code ....Array
		Contact [] contacts = new Contact[10];
		int x = 0 ;
		while(x<10) {
			contacts[x] = new Contact(msg);
			System.out.println(contacts[x]+"Person..");
			contacts[x].printName();
			x++;
		}
	}
}

public class TonysArrayTest {

	public static void main(String[] args) {
		ContactService service = new ContactService();
		service.sendMessage("회의는 10시에 시작합니다.");
		
	}

}/// 결과 : 주소값이 각각 다름
