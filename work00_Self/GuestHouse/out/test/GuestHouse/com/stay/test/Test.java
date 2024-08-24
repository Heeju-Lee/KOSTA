package com.stay.test;

import java.util.ArrayList;

import com.stay.dao.ReserveDao;
import com.stay.vo.GuestHouse;

public class Test {

	public static void main(String[] args) {
		ReserveDao dao = ReserveDao.getInstance();
		
		//dao.createCustomer(new Customer("10", "신승현", "qwer123", "010-1111-1111"));
		
		printlist(dao.findByReviceCount());
		

		
}
	public static void printlist(ArrayList<GuestHouse> list) {
		for(GuestHouse g : list)System.out.println(g);
	}
}