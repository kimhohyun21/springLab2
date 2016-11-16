package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDAO {
	
	@Autowired
	private MovieMapper mapper;
	
	public void movieInsert(MovieVO vo){
		mapper.movieInsert(vo);
	}
}
