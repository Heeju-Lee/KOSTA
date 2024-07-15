package ex01_runtime;
/*
try~catch 구문에서 catch는 여러번 잡을 수 있다.
1. 단, 하나의 catch문만 돈다.
2. 예외를 잡을 때 작은예외 ==>큰예외 순으로 잡아야 한다. 거꾸로 하면 에러 발생한다.
 */

public class RuntimeExceptionTest2 {

	public static void main(String[] args) {
		String[] str = {
			"Hello",
			"No, I mean it",
			"Nice to meet you"		
		};
		
		int i =0;
		
		while(i<=3) {
			try {
				System.out.println(str[i]);//컴파일은 되는데 실행시 터짐. => java.lang.ArrayIndexOutOfBoundsException:
			}catch(NullPointerException e) {//객체생성하지 않고 멤버 접근했을 때 발생하는 폭탄
				System.out.println("NullPointerException...... Nice Catch~!~!~!~!");
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("ArrayIndexOutOfBoundsException...... Nice Catch~!~!~!~!");
			}catch(Exception e) {
				System.out.println("Nice Catch~!~!~!~!");
			}
//			catch(ArithmeticException e) {//분모를 0으로 했을 때 발생하는 폭탄.
//				System.out.println("ArithmeticException...... Nice Catch~!~!~!~!");
//			}
			
			i++;
		}
		System.out.println("The End........");
	}
}
