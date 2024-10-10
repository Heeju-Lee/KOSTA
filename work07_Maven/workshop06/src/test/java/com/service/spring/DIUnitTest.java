package com.service.spring;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.spring.dao.PhoneDAO;
import com.service.spring.domain.Phone;
import com.service.spring.service.PhoneService;

public class DIUnitTest {
	
	String[] appCtxs = {"/beans/businessBean.xml","/beans/presentationBean.xml"};
	
	ApplicationContext factory =
			new ClassPathXmlApplicationContext(appCtxs);
	
	@Test
	public void insert() throws Exception{
		PhoneService service = (PhoneService) factory.getBean("phoneService");
		
		Phone phone = new Phone("P2VX4", "갤럭시 S21", 1600000, "10");
		System.out.println(service.insert(phone)+"건 등록완료");
	}
	
	@Test
	public void select() throws Exception{
		PhoneService service = (PhoneService) factory.getBean("phoneService");
		
		Phone phone = null;
		List<Phone> list = service.select();
		list.forEach(c->System.out.println(c));
	}
	
	@Test
	public void delete() throws Exception{
		PhoneService service = (PhoneService) factory.getBean("phoneService");
		
		List<String> list = new ArrayList<String>();
//		list.add("V50SQ","",0,"");
//		list.add("S105G","",0,"");
		
		System.out.println(service.delete(list));
	}
}
