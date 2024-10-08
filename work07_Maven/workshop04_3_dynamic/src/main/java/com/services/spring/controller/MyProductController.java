package com.services.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.services.spring.dao.MyProductDAO;
import com.services.spring.domain.MyProduct;
import com.services.spring.service.MyProductService;

@Controller
public class MyProductController {
	@Autowired
	private MyProductService myProductService;
	@Autowired
	private MyProductDAO myProductDAO;

	@RequestMapping("/insertProduct.do")
	public ModelAndView addProduct(MyProduct pvo) throws Exception {
		myProductDAO.addProduct(pvo);
		
		//결과페이지는 insert_result.jsp "vo"로 바인딩
		return new ModelAndView("insert_result", "vo", pvo);
	}
	
	@RequestMapping("/findProduct.do")
	public ModelAndView findProduct(String command, String word) throws Exception {
		
		List<MyProduct> list = null;
		MyProduct myProduct = new MyProduct();
		String viewPage = "find_result";
//		
//		if(command.equals("findProductByName")){
//			myProduct.setName(word);
//		}if(command.equals("findProductByMaker")) {
//			myProduct.setMaker(word);
//		}
//		
//        list = myProductService.findProducts(myProduct);
		
		list = myProductService.findProducts(command, word);		
		return new ModelAndView(viewPage,"list",list);
	}
}
;