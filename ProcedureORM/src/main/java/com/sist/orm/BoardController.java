package com.sist.orm;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("board/insert_ok.do")
	public String boardInsert_ok(BoardVO vo){
		dao.boardInsert(vo);
		
		return "redirect:/board/list.do";
	}
	
	@RequestMapping("board/content.do")
	public String boardContentData(int no, int page, Model model){		
		BoardVO vo=dao.boardContentData(no);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
		System.out.println(vo.getSubject());	
		return "board/content";
	}
	
	@RequestMapping("board/update.do")
	public String boardUpdateData(int no, int page, Model model){		
		BoardVO vo=dao.boardUpdateData(no);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);		
		return "board/update";
	}
	
	@RequestMapping("board/update_ok.do")
	public String boardUpdate(BoardVO vo, int page, Model model){		
		
		boolean bCheck=dao.boardUpdate(vo);
		model.addAttribute("bCheck", bCheck);		
		model.addAttribute("page", page);		
		return "board/update_ok";
	}
	
	@RequestMapping("board/delete.do")
	public String boardDelete(int page, int no, Model model){		
		
		model.addAttribute("no", no);			
		model.addAttribute("page", page);		
		return "board/delete";
	}
	
	@RequestMapping("board/delete_ok.do")
	public String boardDelete(int no, int page, String pwd, Model model){		
		System.out.println(no);
		System.out.println(pwd);
		boolean bCheck=dao.boardDelete(no, pwd);
		model.addAttribute("bCheck", bCheck);
		model.addAttribute("page", page);		
		return "board/delete_ok";
	}
}
