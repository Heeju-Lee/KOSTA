package ex02_compile;

import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading{
	public void readFile(String fileName) {
		System.out.println("2. readFile calling....");
		
		//자바에서 파일을 읽어들이기 위해서는 FileReader 객체를 생성해야함
		try {
			FileReader reader = new FileReader(fileName);
			System.out.println("파일을 성공적으로 찾았습니다.");
		} catch (FileNotFoundException e) {
//			System.out.println("파일을 찾지 못했습니다.");
//			e.printStackTrace();//자동출력, 보안상 정보유출위험이 있어 개발시는 쓰되 배포시에는 막아둬야함 지금은 개발할 때도 안씀
			System.out.println(e.getMessage());
		}
		
	}
}

public class CompileExceptionTest1 {
	public static void main(String[] args) {
		System.out.println("1. FileReading 객체 생성....");
		FileReading fr = new FileReading();
		
		fr.readFile("text.txt");
		
		System.out.println("3. 파일을 잘 읽어들였습니다....");

	}

}
