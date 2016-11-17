package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDAO {
	
	@Autowired
	private MovieMapper mapper;
	
	public void movieInsert(MovieVO vo){
		mapper.movieInsert(vo);
	}
	
	public List<MovieVO> movieListData(Map map){
		return mapper.movieListData(map);
	}
	
	public int totalPageCount(){
		return mapper.totalPageCount();
	}
}
