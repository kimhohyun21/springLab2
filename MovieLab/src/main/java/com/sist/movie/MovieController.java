package com.sist.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.*;

import java.util.*;

@Controller
public class MovieController {
	
	@Autowired
	private MovieDAO dao;
	
	@RequestMapping("movie/list.do")
	public String movieList(String page, Model model){
		if(page==null)page="1";
		int curPage=Integer.parseInt(page);
		
		int rowSize=7;
		int start=(rowSize*curPage)-(rowSize-1);
		int end=rowSize*curPage;
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		//리스트 불러오기
		List<MovieVO> list=dao.movieListData(map);
		
		//전체페이지
		int totalPage=dao.totalPageCount();
		
		//블럭 지정
		int block=5;
		int fromPage=((curPage-1)/block*block)+1;
		int toPage=((curPage-1)/block*block)+block;
		
		model.addAttribute("block", block);
		model.addAttribute("fromPage", fromPage);
		model.addAttribute("toPage", toPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("list", list);
		model.addAttribute("curPage", curPage);		
		
		return "movie/list";
	}
}
