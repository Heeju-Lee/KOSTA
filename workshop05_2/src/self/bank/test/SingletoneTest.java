package self.bank.test;

import self.bank.service.BankService;

public class SingletoneTest {

	public static void main(String[] args) {
		//BankService s1 = new BankService();
		BankService s1=BankService.getInstance();	
		BankService s2=BankService.getInstance();		
		BankService s3=BankService.getInstance();
		
		System.out.println(s1);//레퍼런스변수 뒤에는 항상 toString이 생략돼있음.
		System.out.println(s2);
		System.out.println(s3);
		System.out.println("======================================");
		System.out.println(s3.toString());
	}

}
