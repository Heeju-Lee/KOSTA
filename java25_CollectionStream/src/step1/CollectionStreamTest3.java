package step1;

import java.util.Arrays;
import java.util.List;

public class CollectionStreamTest3 {

	public static void main(String[] args) {
		
		// 직렬처리 
//		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//		long start = System.currentTimeMillis();
//		numbers.forEach(number -> {
//		try {
//			Thread.sleep(1000);//main 이 thread임. sleep(1000) 1초 block
//			System.out.println(number + ": " + Thread.currentThread().getName());
//		} catch (InterruptedException e) {}	
//		});
//		long duration = (System.currentTimeMillis() - start);
//		double seconds = duration / 1000.0;
//		System.out.printf("Done in %.2f sec\n", seconds);
		
		//병렬처리
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		long start = System.currentTimeMillis();
		numbers.parallelStream().forEach(number -> {
		try {
			Thread.sleep(1000);//main 이 thread임. sleep(1000) 1초 block
			System.out.println(number + ": " + Thread.currentThread().getName());
		} catch (InterruptedException e) {}	
		});
		long duration = (System.currentTimeMillis() - start);
		double seconds = duration / 1000.0;
		System.out.printf("Done in %.2f sec\n", seconds);
	
	}
}
