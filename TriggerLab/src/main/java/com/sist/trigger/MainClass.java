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
		
		System.out.println("********�԰���***********");
		for(GoodsVO vo : list){
			System.out.println(vo.get��ǰ�ڵ�()+" "+vo.get��ǰ��()+" "
								+vo.get������()+" "+vo.get�Һ��ڰ���()+" "
								+vo.get������());
		}
		
		//�μ�Ʈ �԰�
		InputVO vo1=new InputVO();
		
		vo1.set��ǰ�ڵ�("A00001");
		vo1.set�԰�����("20161118");
		vo1.set�԰����(20);
		vo1.set�԰�ܰ�(500);
		vo1.set�԰�ݾ�(10000);
		dao.inputInsert(vo1);
		
		
		List<GoodsVO> list2=dao.goodsAllData();
		
		System.out.println("********�԰���***********");
		for(GoodsVO vo : list2){
			System.out.println(vo.get��ǰ�ڵ�()+" "+vo.get��ǰ��()+" "
								+vo.get������()+" "+vo.get�Һ��ڰ���()+" "
								+vo.get������());
		}
	}
}
