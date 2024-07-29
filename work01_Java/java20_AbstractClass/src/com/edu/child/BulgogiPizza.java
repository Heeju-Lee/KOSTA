package com.edu.child;

import com.edu.parent.Pizza;

public class BulgogiPizza extends Pizza {

	public BulgogiPizza(int price, String storeName) {
		super(price, storeName);
	}

	@Override
	public void topping() {
		System.out.println("Bulgogi Topping....Pizza");
	}
	

}
