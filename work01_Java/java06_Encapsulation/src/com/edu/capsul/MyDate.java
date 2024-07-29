package com.edu.capsul;
//오늘 날짜정보를 저장하는 클래스
public class MyDate {

	private int month;
	private int day;
	
	
	  public void setMonth(int month) { 
		  if (month <=12 && month > 0) { 
			  this.month = month; 
		  }
		  else{ 
			  errorMsg("Month Error"); 
			  System.exit(0); } 
		  }
	 
		
	public int getMonth() {
		return month;
		}
	
	public void setDay(int day) {
		switch (month){
		case 2:
			if(day<=28 && day>=1){
				this.day = day;
			}
			else {
				errorMsg("Day Error");
				System.exit(0);
			}
			
			break;
			
		case 4:
		case 6:
		case 9:
		case 11:
			if(day<=30 && day>=1) {
				this.day = day;
			}else {
				errorMsg("Day Error");
				System.exit(0);
			}
			break;
		
		default:
			if(day<=31 && day>=1) {
				this.day = day;
			}
			else {
				errorMsg("Day Error");
				System.exit(0);
			}
		}//switch
	}//setmonth

	
	public int getDay() {
		return day;
	}
		
	//에러메세지를 출력하는 기능을 추가
	private void errorMsg(String value) {
		System.out.print("Invalid Value..."+value);////month, day 안뜸
	}//switch
	
}
	
