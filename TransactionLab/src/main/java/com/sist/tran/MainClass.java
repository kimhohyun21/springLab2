package com.sist.tran;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		
		CardDAO dao= (CardDAO) app.getBean("cardDAO");
		dao.insert("kim21", 30000);		
		System.out.println("Ä«µå½ÂÀÎ");
	}
}
