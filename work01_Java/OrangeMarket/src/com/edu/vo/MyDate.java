package com.edu.vo;

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	@Override
	public String toString() {
		return year + "-" + month + "-" + day;
	}
	
	public static MyDate inputSc(String dateStr) {
        String[] parts = dateStr.split("-");
      
        if (parts.length != 3) {
            throw new IllegalArgumentException("형식을 확인하시고 다시 입력해주세요.");
        }
        
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        return new MyDate(year, month, day);
    } 
	
}
