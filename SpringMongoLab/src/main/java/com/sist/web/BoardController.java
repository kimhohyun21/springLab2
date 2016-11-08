package com.sist.web;

import com.sist.dao.*;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("main/list.do")
	public String board_list(String page, Model model) {
		if(page==null)page="1";
		int curPage=Integer.parseInt(page);
		
		List<BoardVO> list = dao.boardListData(curPage);
		int totalPage=dao.boardTotalPage();
		String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		model.addAttribute("curPage",curPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("today",today);
		model.addAttribute("list", list);
		
		return "main/list";
	}
	
	@RequestMapping("main/insert.do")
	public String board_insert(){
		return "main/insert";
	}
	
	@RequestMapping("main/insert_ok.do")
	public String board_insert_ok(BoardVO vo){
		
		String day=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		vo.setRegdate(day);
		dao.boardInsert(vo);
		
		return "redirect:/main/list.do";
	}
	
	@RequestMapping("main/content.do")
	public String board_content(int no, int page, Model model){
		BoardVO vo=dao.boardContentData(no);
		
		model.addAttribute("page", page);
		model.addAttribute("vo", vo);
		return "main/content";
	}
	
	@RequestMapping("main/update.do")
	public String board_update(int no, int page, Model model){
		BoardVO vo=dao.boardContentData(no);
		
		model.addAttribute("page", page);
		model.addAttribute("vo", vo);
		return "main/update";
	}
	
	@RequestMapping("main/update_ok.do")
	public String board_update(BoardVO vo, int page, Model model){
		boolean bCheck=dao.boardUpdateOk(vo);
	
		model.addAttribute("no", vo.getNo());
		model.addAttribute("page", page);
		model.addAttribute("bCheck", bCheck);
		return "main/update_ok";
	}
}