package com.sist.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.Board;

@Controller
public class BoardController {
	
	@Autowired
	private Board board;
	
	@RequestMapping("test/check.do")
	public String check(){
		
		String str="";
		
		try{
			System.out.println("===Start=====");		//1¹ø 
			// Before
			System.out.println("Board-Name: " +board.getBoardName()); 
			System.out.println("====End====");
			
			str="";  //
			
		}catch(Exception ex){
			//System.out.println(ex.getMessage());
			str="test/error";
		}
		
		
		return str;
	}
}
























