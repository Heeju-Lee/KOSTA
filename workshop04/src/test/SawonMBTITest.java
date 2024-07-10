package test;
import java.util.Arrays;
import java.util.Scanner;
/*
6
1 4 4 4 5 3
*/
public class SawonMBTITest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("K전자 신입사원수 입력 >>> ");
		int num = sc.nextInt();//배열의 사이즈
		int[ ] people =new int[num]; //6
		
	    System.out.println("공백을 기준으로 각 사원에 대한 성격 유형을 직접 입력 >>> ");
		
	    //배열 초기화
		for(int i=0; i<people.length; i++) {
			people[i] = sc.nextInt(); //1,4,4,4,5,3(5가지의 타입이 있음)
		}//사람들의 타입 지정이 끝났음...
		
			
		
		// 코드 작성
		Arrays.sort(people);//people 배열 정렬 5,4,4,4,3,1
		int answer = 0;//최빈값 자리, 추후 출력
		
		int maxCnt = 1;//최빈값 빈도수 초기화
		int currentCnt = 1;//현재 숫자의 빈도수, 초기화
		
		for(int i = 1; i<people.length; i++) {
			if(people[i] == people[i-1]) {//[1]과 [0]이 같으
				currentCnt++;//현재 숫자의 빈도수를 증가시킴
			}else {
				if(currentCnt > maxCnt) {
					maxCnt = currentCnt;
					answer = people[i-1];
				}
				currentCnt = 1;//현재 숫자의 빈도수 초기화
			}
		}
		
		//마지막 숫자의 빈도수 처리
		if (currentCnt>maxCnt) {
			maxCnt = currentCnt;
			answer = people[people.length-1];
		}
		
		System.out.println("정답 :: "+answer);
	}
}
