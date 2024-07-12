package com.edu.collection1;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

//시스템 위에 탐재된 자바관련 환경변수들이 어떤 값들이 있는지
//전부다 가져와서 콘솔로 출력해보겠다.
public class PropertiesTest1 {

	public static void main(String[] args) {
		Properties p =System.getProperties();//시스템 환경변수 map
		
/*		//1.Enumeration 사용법(예전방식) 
		Enumeration en =p.propertyNames();
		// 키를 뽑고  키에 해당하는 값을 뽑는다.
		while(en.hasMoreElements()) {//있는지 없는지 확인 
			String key = (String) en.nextElement();
			String value = (String) p. get(key);
			
			System.out.println(key+"========================"+value);*/
		
		//2. Iterator 사용법
		
//		Set set =p.keySet();//set 받아서 
//		Iterator<String> it =set.iterator();//set의 함수를 쓰고 
//		while(it.hasNext()) { 
//			String key = it.next(); 
//			String value = (String)
//			p.get(key); System.out.println(key+"========================"+value); 
//		}
		 
//		//3.
//		Iterator it = p.keySet().iterator();
//		while(it.hasNext()) { 
//			String key = (String) it.next();
//			String value = (String)p.get(key);
//			System.out.println(key+"========================"+value); 
//		}
		
//		//4. for
//		for(Object key : p.keySet()) {
//			String value =(String)p.get(key);
//			System.out.println(key+"========================"+value); 
//		}
		
		//5. forEach. 람다식. java 1.8버전 이상에서만 사용가능하다.
		p.forEach((key, value)->
			System.out.println(key+"========================"+value)
		);
		
	}//main 
}//class
