import java.util.Random;
import java.util.Scanner;

public class GameTest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(">>가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.print("번호를 입력하세요. ");
		int type = sc.nextInt();//게임타입 int 입력

		int game = 0;
		int judge = 0;
		int win = 0;
		int lose = 0;//필드초기화

		if (type == 1) {
			game = 5;
			judge = 3;
		} else if (type == 2) {
			game = 3;
			judge = 2;
		} else {
			game = 1;
			judge = 1;
		}//게임타입 지정 시 for문에 게임횟수 및 승부 넣음

		for (int i = 0; i < game && win < judge && lose < judge; i++) {
			int com = (int) (Math.random() * 3) + 1;
			// System.out.println("com=" + com);
			System.out.print("가위바위보 중 하나 입력: ");
			String s = sc.next();
			int in = 0;
			if (s.equals("가위")) {
				in = 1;
			} else if (s.equals("주먹")) {
				in = 2;
			} else if (s.equals("보")) {
				in = 3;
			}//입력된 String 값 -> com 비교위해 변환
			if (com == in) {
				System.out.println("비겼습니다!!!");
			} else if ((com == 1 && in == 2) || (com == 2 && in == 3) || (com == 3 && in == 1)) {
				System.out.println("이겼습니다!!!");
				win++;
			} else {
				System.out.println("졌습니다!!!");
				lose++;
			}// true이면 승패여부 출력 후 해당 값을 더해줌
		}
		String result = "무승부";
		if (win == lose) {
			result = "무승부";
		} else if (win > lose) {
			result = "컴퓨터 패";
		} else {
			result = "컴퓨터 승";
		}
		System.out.println("\n### " + result + "!!!");
	}//최종결과 값 출력

}
