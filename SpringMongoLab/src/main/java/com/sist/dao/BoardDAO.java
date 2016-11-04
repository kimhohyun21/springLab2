package com.sist.dao;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

@Repository
public class BoardDAO {
	private MongoClient mc;		//RDBMS�� Connection ���� 
	private DBCollection dbc;	//RDBMS�� table ����
	private DB db;				//RDBMS�� database �̸� ==> ORCL�� ���� ��
	
	public BoardDAO(){
		try{
			mc=new MongoClient("localhost");
			db=mc.getDB("mydb");
			dbc=db.getCollection("board");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public List<BoardVO> boardListData(){
		List<BoardVO> list=new ArrayList<BoardVO>();
		return list;
	}
}








































