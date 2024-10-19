package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.Item;
import com.service.spring.service.ItemCatalog;

@Controller
public class FruitController {
	
	@Autowired
	private ItemCatalog itemCatalog;
	
	@RequestMapping("/itemList.do")
	public ModelAndView list() throws Exception{
		List<Item> list = itemCatalog.getItemList();
		return new ModelAndView("itemList","list",list);
	}
	
	@RequestMapping("/itemView.do")
	public ModelAndView detail(int itemnumber) throws Exception{
		Item item = itemCatalog.getItem(itemnumber);
		return new ModelAndView("itemView","item",item);
	}
}
