package com.service.spring;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.dao.BoardDAO;
import com.service.spring.domain.Board;
import com.service.spring.domain.Member;
import com.service.spring.service.BoardService;

public class DIUnitTest {
	
	ApplicationContext factory =
			new ClassPathXmlApplicationContext("/beans/application.xml");
	
	//myBatis와 DI연동 부분의 단위테스트...빈 설정문서를 읽어야 함.
	@Test
	public void write() throws Exception{

		//IOC로부터 MyProductDAO, MyProductService 객체를 반환
		//어노테이션을 했기 때문에 경로가 아닌 클래스명
		BoardDAO dao = (BoardDAO) factory.getBean("boardDAO");
		BoardService service = (BoardService) factory.getBean("boardService");
		Board pvo = new Board("가입인사6","반가워요^^6",new Member("jeolmi4", "1234", "절미", "종각"));
		
		System.out.println("========== write ==========");
		dao.write(pvo);
	}
	
	@Test
	public void getBoardList() throws Exception{
		
		System.out.println("========== getBoardList ==========");
		BoardService service = (BoardService) factory.getBean("boardService");
		List<Board> list = service.getBoardList();
		for(Board b: list) System.out.println(b);
		
		System.out.println("========== showContent ==========");
		int no = 11;
		Board board = service.showContent(no);
		System.out.println(board);
	}
}
