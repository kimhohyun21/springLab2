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
		
		//���ν����� �����  CALL �Լ��� ����ϴ� ���� mapper�� ȣ���� �� update�� ���
		getSqlSession().update("boardListData", map);
		//���� ���� hashMap�� ����Ǵ� ������ �Ǿ� �ֱ� ������ ���� ���� map���� �޾ƿ´�
		List<BoardVO> list=(List<BoardVO>) map.get("pResult");
		
		return list;
	}
	
	public int boardTotalPage(){		
		Map map=new HashMap();
		
		getSqlSession().update("boardTotalPage", map);
		int totalPage=(Integer) map.get("pNumber");	
		
		return totalPage;
	}
	
	public void boardInsert(BoardVO vo){		
		Map map=new HashMap();
		map.put("pName", vo.getName());
		map.put("pSub", vo.getSubject());
		map.put("pCont", vo.getContent());
		map.put("pPwd", vo.getPwd());
		
		getSqlSession().update("boardInsert", map);
	}
}
