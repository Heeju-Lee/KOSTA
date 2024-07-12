package com.edu.service.impl;

import com.edu.parent.Pizza;
import com.edu.service.PizzaService;

public class PizzaServiceImpl implements PizzaService{

	
	private static PizzaServiceImpl service = new PizzaServiceImpl();//1
	private PizzaServiceImpl() {}//2
	public static PizzaServiceImpl getInstance() {
		return service;
	}//3
	
	@Override
	public void allMakePizza(Pizza[] pizzas) {	
		for(Pizza p : pizzas) {
			System.out.println(p);
			p.sequencePizza();
			System.out.println("==============================");
		}
	}
	

}
