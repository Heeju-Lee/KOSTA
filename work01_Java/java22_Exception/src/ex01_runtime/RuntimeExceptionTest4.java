package ex01_runtime;
/*

try -- dPdhlrksmdtjd dlTsms zhem
catch -- 예외 발생시 잡는 코드
finally -- !!! 예외 발생과 상관ㅇ벗이 무조건 실행되어야 하는 코드

 */

public class RuntimeExceptionTest4 {

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
			}catch(Exception e) {
				System.out.println("Exception....Nice Catch~!~!~!~!");
			}finally{
				//이 부분을 어떨때 과연 사용할까...
				System.out.println("이 부분은 무조건 실행 됩니다... 예외 발생여부와 상관없이.");
			}
			i++;
		}
		System.out.println("The End........");
	}
}
