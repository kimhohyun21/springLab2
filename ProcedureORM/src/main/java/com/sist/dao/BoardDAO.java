package com.sist.dao;

import java.util.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BoardDAO extends SqlSessionDaoSupport{
	
	public List<BoardVO> boardListData(int page){		
		int rowSize=10;
		int start=(rowSize*page)-(rowSize-1);
		int end=(rowSize*page);
		
		Map map=new HashMap();
		map.put("pStart", start);
		map.put("pEnd", end);		
		
		//프로시져를 사용한  CALL 함수를 사용하는 경우는 mapper를 호출할 때 update를 사용
		getSqlSession().update("boardListData", map);
		//리턴 값이 hashMap에 저장되는 것으로 되어 있기 때문에 리턴 값을 map에서 받아온다
		List<BoardVO> list=(List<BoardVO>) map.get("pResult");
		
		return list;
	}
	
	public int boardTotalPage(){		
		Map map=new HashMap();
		
		getSqlSession().update("boardTotalPage", map);
		int totalPage=(Integer) map.get("pNumber");	
		
		return totalPage;
	}
	
}
