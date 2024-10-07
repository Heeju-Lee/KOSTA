package com.service.spring.controller;

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
	
}
