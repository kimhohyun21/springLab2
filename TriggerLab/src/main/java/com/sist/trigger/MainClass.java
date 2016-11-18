package com.sist.trigger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.Insets;
import java.util.*;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		
		TriggerDAO dao=(TriggerDAO) app.getBean("triggerDAO");
		List<GoodsVO> list=dao.goodsAllData();
		
		System.out.println("********입고전***********");
		for(GoodsVO vo : list){
			System.out.println(vo.get상품코드()+" "+vo.get상품명()+" "
								+vo.get제조사()+" "+vo.get소비자가격()+" "
								+vo.get재고수량());
		}
		
		//인서트 입고
		InputVO vo1=new InputVO();
		
		vo1.set상품코드("A00001");
		vo1.set입고일자("20161118");
		vo1.set입고수량(20);
		vo1.set입고단가(500);
		vo1.set입고금액(10000);
		dao.inputInsert(vo1);
		
		
		List<GoodsVO> list2=dao.goodsAllData();
		
		System.out.println("********입고후***********");
		for(GoodsVO vo : list2){
			System.out.println(vo.get상품코드()+" "+vo.get상품명()+" "
								+vo.get제조사()+" "+vo.get소비자가격()+" "
								+vo.get재고수량());
		}
	}
}
