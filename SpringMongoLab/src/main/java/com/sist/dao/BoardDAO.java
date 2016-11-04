package com.sist.dao;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

@Repository
public class BoardDAO {
	private MongoClient mc;		//RDBMS의 Connection 역할 
	private DBCollection dbc;	//RDBMS의 table 개념
	private DB db;				//RDBMS의 database 이름 ==> ORCL과 같은 것
	
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








































