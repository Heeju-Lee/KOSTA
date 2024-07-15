package ex02_compile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileReading2{
	public void readFile(String fileName) {
		System.out.println("2. readFile calling....");
		
		//자바에서 파일을 읽어들이기 위해서는 FileReader 객체를 생성해야함
		FileReader reader = null;

		try {
			reader = new FileReader(fileName);;//stream 생성 자원을 열었다. 
			System.out.println("파일을 성공적으로 찾았습니다.");
		} catch (FileNotFoundException e) {
//			System.out.println("파일을 찾지 못했습니다.");
//			e.printStackTrace();//자동출력, 보안상 정보유출위험이 있어 개발시는 쓰되 배포시에는 막아둬야함 지금은 개발할 때도 안씀
			System.out.println(e+", catch");
		}finally {
			try {
			System.out.println("자원 반환....");
			reader.close();
			
			}catch(IOException e) {
				System.out.println(e);
			}
		}
	}
}


public class CompileExceptionTest2 {
	public static void main(String[] args) {
		System.out.println("1. FileReading2 객체 생성....");
		FileReading4 fr = new FileReading4();
		
		try {
			fr.readFile("text.txt");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		System.out.println("3. 파일을 잘 읽어들였습니다....");

	}

}
