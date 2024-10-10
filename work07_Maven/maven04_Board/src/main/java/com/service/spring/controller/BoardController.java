package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.Board;
import com.service.spring.domain.Member;
import com.service.spring.service.BoardService;
import com.service.spring.service.MemberService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/write.do")
	public String doWrite(Board bvo, HttpSession session, Model model) {
		
		Member mvo = (Member) session.getAttribute("mvo");
		if(mvo==null) return "redirect:index.jsp";

		try {
			bvo.setMember(mvo);
			model.addAttribute("bvo",bvo);
			boardService.write(bvo);//인자값으로 들어온 위의 bvo와는 다르다!! (mvo 가 채워짐)
			
			return "board/show_content";
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("message","게시판 작성 - 에러발생");
			return "Error";
		}//catch
	}//write
	
	@RequestMapping("list.do")
	public String list(Model model){
		
		try {
			List<Board> list = boardService.getBoardList();
			model.addAttribute("list",list);
			return "board/list";//InternalResourceViewResolver의 영향을 받는다.
		}catch (Exception e) {
			System.out.println(e);
			model.addAttribute("message","게시판 리스트 - 에러발생");
			return "Error";
		}
	}//list
	
	//1. 로그인한 사람만이 볼 수 있게
	//2. updateCount 
	@RequestMapping("showContent.do")
	public String showDetail(int no, Model model, HttpSession session) {
		
		if(session.getAttribute("mvo")==null) 
			return "redirect:index.jsp";
		
		try {
			boardService.updateCount(no);
			Board bvo = boardService.showContent(no);//상세글 보려할 때 카운트 하나 올려놓고
			model.addAttribute("bvo",bvo);
			return "board/show_content";
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("message","게시판 상세보기 - 에러발생");
			return "Error";
		}
	}//showDetail
	
	// 함수명에 do가 붙는다면 행위이다. 
	// :: login                                  / :: doLogin 
	// 해당 메소드를 실행하면 로그인을 할 수 있는 form이 나온다./ 해당메소드에서 직접로그인 기능이 나온다.	
	@RequestMapping("delete.do")
	public String doDelete(int no, Model model) {
		try {
			boardService.deleteBoard(no);
			/*
			 * List<Board> list = boardService.getBoardList();
			 * model.addAttribute("list",list);
			 */
			return "redirect:list.do";
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("message","삭제 - 에러발생");
			return "Error";
		}
	}//doDelete
	
	@RequestMapping("updateView.do")
	public String update(int no, Model model) {
		try {
			Board bvo = boardService.showContent(no);
			model.addAttribute("bvo",bvo);
			return "board/update";
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("message","업데이트 페이지 이동 - 에러발생");
			return "Error";
		}
	}//update
	
	@RequestMapping("updateBoard.do")
	public String doUpdate(Board pvo, Model model, HttpSession session) {
		System.out.println("Before pvo :: "+pvo);
		try {
			boardService.updateBoard(pvo);
			Board board = boardService.showContent(pvo.getNo());
			model.addAttribute("bvo",board);
			return "board/show_content";
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("message","업데이트 진행중 - 에러발생");
			return "Error";
		}
	}//update
	
	
	
	
	
	
}
