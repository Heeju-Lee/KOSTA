package web.servlet.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Item;
import web.servlet.model.ItemDao;

/*
  하나의 컴포넌트에서 2개의 비즈니스 로직이 호출될 수도 있다.
  하나의 fruit 정보 받아오기
  +
  조회수 증가하기
  
 */

public class ItemViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemnum = Integer.parseInt(request.getParameter("itemnumber"));
		System.out.println("ItemViewController....execute.."+itemnum);
		
		//1. 이 부분이 먼저 동작한 후 getItem()이 호출되어야 한다.
		boolean result =ItemDao.getInstance().updateRecordCount(itemnum);
		System.out.println("count update? "+ result);
		
		//2.
		Item item=ItemDao.getInstance().getItem(itemnum);
		System.out.println("getItem()? "+item);		
		
		////////////////// 오늘 본 상품 정보를 쿠키에 저장하는 로직 추가 //////////////////
		//3. 1) 쿠키 생성 ... 정보 저장  2) 생성한 쿠키를 클라이언트(브라우저)로 보냄
		Cookie cookie = new Cookie("fruitshop"+itemnum,item.getUrl()); //쿠키를 불러올 때 저장된 값이 모두 불러와지기에 앞에 인덱싱
		
		cookie.setMaxAge(24*60*60);
		response.addCookie(cookie);
		
		request.setAttribute("item", item);
		return new ModelAndView("itemView.jsp");
		
		////// 로컬스토리지에 정보저장
		
	}

}