package com.edu.bank;
	/**
	 *	<pre>
	 *	{@code 
	 *	은행 계좌 정보를 저장하는 클래스
	 *	
	 *	이번 Java Document 주석 사용법을 예시로 작성
	 *	이런 작업은 공동작업을 하기 위한 효율적 작업으로 사용되거나
	 *	혹은
	 *	개발자가 자신의 코드를 보완설명하기 위해서 반드시 사용하는 작업 방식입니다. 
	 *	}
	 *
	 *	</pre>
	 * 	
	 * 	@author LEE HEE JU
	 * 	@version Test Project version 1.0.1
	 * 	@since JDK 17
	 */
public class Account {
	/**
	 * 계좌번호
	 * 8자리 숫자로 지정
	 */
	public int accNumber;
	/**
	 * 은행명
	 */
	public String bankName;
	/**
	 * 계좌에 남아있는 잔액
	 * 혹은 
	 * 개설시 필요한 조건으로서의 잔액
	 */
	public double balance;
	
	/**
	 * Account 기본생성자
	 */
	public Account() {};
	/**
	 * Account 명시적 생성자
	 * @param accNumber 계좌번호
	 * @param bankName 은행명
	 * @param balance 통장개설시 초기잔액
	 */
	public Account(int accNumber, String bankName, double balance) {
		this.accNumber = accNumber;
		this.bankName = bankName;
		this.balance = balance;
	}
	/**
	 * @return 계좌번호 반환
	 */
	public int getAccNumber() {
		return accNumber;
	}
	/**
	 * @return 은행명 반환
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * 
	 * @param bankName 
	 * 은행명 설정
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * @return 잔액 반환 
	 */
	public double getBalance() {
		return balance;
	}	
	/**
	 * 
	 * @param balance
	 * 통장을 개설한 이후에 잔액을 다시 입력하는 기능
	 * @deprecated deposit 메소드로 대체 {@link #deposit(double)}
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * @param amt
	 * 입금 금액만큼 잔액 증가
	 */
	public void deposit(double amt) {
		balance += amt;
	}
	/**
	 * @param amt 
	 * 출금 금액만큼 잔액 감소
	 */
	public void withdraw(double amt) {
		balance -= amt;
	}
	/**
	 * 
	 * @return 계좌정보 반환(계좌번호, 은행명, 잔액)
	 */
	public String getAccountInfo() {
		return accNumber+", "+bankName+", "+balance;
	}

}
