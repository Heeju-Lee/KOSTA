package workshop12;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CoffeeOrderTest {

	public static void main(String[] args) {
		List<String> coffees = new ArrayList<String>();
		
		coffees.add("Cappuccino");
		coffees.add("Americano");
		coffees.add("Espresso");
		coffees.add("Caramel Macchiato");
		coffees.add("Mocha");
		coffees.add("Cappuccino");
		coffees.add("Espresso");
		coffees.add("Latte");
		
		Stream<String> stream = coffees.stream();
		stream.filter(s -> s.endsWith("o")).sorted().distinct().forEach(System.out::println);;
	}
}
