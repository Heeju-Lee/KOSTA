package com.edu.test;

import com.edu.child.BulgogiPizza;
import com.edu.child.CombinationPizza;
import com.edu.child.PotatoPizza;
import com.edu.parent.Pizza;
import com.edu.service.impl.PizzaServiceImpl;

public class PizzaServiceTest {

	public static void main(String[] args) {
		PizzaServiceImpl service = PizzaServiceImpl.getInstance();
		
		Pizza[] pizzas = {
			new PotatoPizza(23000, "MrPizza"),
			new BulgogiPizza(30000, "PizzaHut"),
			new CombinationPizza(34000, "Kosta"),	
		};
		
		service.allMakePizza(pizzas);

	}

}
