package com.sist.orm;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.sist.dao.*;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("board/list.do")
	public String boardListData(String page, Model model){
		if(page==null)page="1";
		int curPage=Integer.parseInt(page);
		
		int totalPage=dao.boardTotalPage();
		List<BoardVO> list=dao.boardListData(curPage);		
		String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		model.addAttribute("today", today);
		model.addAttribute("curPage", curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@RequestMapping("board/insert.do")
	public String boardInsert(){
		
		return "board/insert";
	}
}
