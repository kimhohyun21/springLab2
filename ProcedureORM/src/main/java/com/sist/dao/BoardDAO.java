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
	
	public BoardVO boardContentData(int no){
		Map map=new HashMap();
		map.put("pNo", no);
		getSqlSession().update("boardContentData", map);		
		List<BoardVO> list=(List<BoardVO>)map.get("pResult");		
		return list.get(0);
	}
	
	public BoardVO boardUpdateData(int no){
		Map map=new HashMap();
		map.put("pNo", no);
		getSqlSession().update("boardUpdateData", map);		
		List<BoardVO> list=(List<BoardVO>)map.get("pResult");		
		return list.get(0);
	}
	
	public boolean boardUpdate(BoardVO vo){
		boolean bCheck=false;
		
		Map map=new HashMap();
		map.put("pNo", vo.getNo());
		map.put("pName", vo.getName());
		map.put("pSubject", vo.getSubject());
		map.put("pContent", vo.getContent());
		map.put("pPwd", vo.getPwd());
		
		getSqlSession().update("boardUpdate", map);		
		String res=(String) map.get("pResult");
		bCheck=Boolean.parseBoolean(res);
		return bCheck;
	}
	
	public boolean boardDelete(int no, String pwd){
		boolean bCheck=false;
		
		Map map=new HashMap();
		map.put("pNo", no);
		map.put("pPwd", pwd);
		getSqlSession().update("boardDelete", map);
		
		String res=(String) map.get("pResult");
		bCheck=Boolean.parseBoolean(res);
		return bCheck;
	}
	
}
