package com.algo;


import java.util.TreeMap;

public class Count {

	public String execute(String book) {
		book=book.toLowerCase();
		String[] str = book.split(" ");
		TreeMap<String, Integer> ans = new TreeMap<String, Integer>();
		for (int i = 0; i < str.length; i++) {
			if (ans.containsKey(str[i])) {
				ans.put(str[i], ans.get(str[i]) + 1);
			} else {
				ans.put(str[i], 1);
			}
		}
		int max = 0;
		String word = "";
		for (String key : ans.keySet()) {
			if (max < ans.get(key)) {
				max = ans.get(key);
				word = key;
			}
		}
		return word;
	}

 public static void main(String[] args) {
		String book1 ="Can Danny and his father outsmart the villainous Mr. Hazell? Danny has a life any boy would love - his home is a gypsy caravan, he's the youngest master car mechanic around, and his best friend is his dad, who never runs out of wonderful stories to tell. But one night Danny discovers a shocking secret that his father has kept hidden for years. "; 
		String book2 ="Soon Danny finds himself the mastermind behind the most incredible plot ever attempted against nasty Victor Hazell, a wealthy landowner with a bad attitude. Can they pull it off? If so, Danny will truly be the champion of the world.";
		String book3 ="I like cat. I like cat. I like cat. ";
		Count c = new Count();
		System.out.println(c.execute(book1));
		System.out.println(c.execute(book2));
		System.out.println(c.execute(book3));

	}

}
