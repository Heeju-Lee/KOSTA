package ex02_compile;
//예외를 처리하는 또 다른 방법 중 throws
//즉각적으로 예외를 처리하지 않고 호출한 지점으로 예외를 던지는 방법
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileReading3{
	public void readFile(String fileName) throws FileNotFoundException, IOException{
		System.out.println("2. readFile calling....");
		
		//자바에서 파일을 읽어들이기 위해서는 FileReader 객체를 생성해야함
		FileReader reader = null;

		try {
			reader = new FileReader(fileName);;//stream 생성 자원을 열었다. 
			System.out.println("파일을 성공적으로 찾았습니다.");
		}finally {
			System.out.println("자원 반환....");
			reader.close();
		}	
	}//method
}//class

public class CompileExceptionTest3 {
	public static void main(String[] args) {
		System.out.println("1. FileReading2 객체 생성....");
		FileReading4 fr = new FileReading4();
		
		try {
			fr.readFile("text.txt");
		} catch (IOException e) {
			System.out.println("잡았다...");
		}
		
		System.out.println("3. 파일을 잘 읽어들였습니다....");

	}

}