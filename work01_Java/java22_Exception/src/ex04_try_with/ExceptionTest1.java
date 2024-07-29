package ex04_try_with;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionTest1 {

	public static void main(String[] args) throws IOException{
		FileWriter file = null;
		try {
			file = new FileWriter("data.txt");//출력용 파일은 자동으로 기본 경로에 생성된다. file 이 sink가 됨.
			file.write("Hello world");
		} finally {
				file.close();
		}
		
	}

}
