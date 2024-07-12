package com.edu.child;

import com.edu.parent.Pizza;

public class PotatoPizza extends Pizza {

	public PotatoPizza(int price, String storeName) {
		super(price, storeName);
	}

	@Override
	public void topping() {
		System.out.println("Potato Topping....Pizza");
	}

}
