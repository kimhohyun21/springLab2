package com.sist.dao;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

@Repository
public class BoardDAO {
	private MongoClient mc;		//RDBMS�� Connection ���� 
	private DBCollection dbc;	//RDBMS�� table ����
	private DB db;				//RDBMS�� database �̸� ==> ORCL�� ���� ��
	
	//connection
	public BoardDAO(){
		try{
			mc=new MongoClient("localhost");
			db=mc.getDB("mydb");
			dbc=db.getCollection("board");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	//����Ʈ �ҷ�����
	public List<BoardVO> boardListData(int page){
		List<BoardVO> list=new ArrayList<BoardVO>();
		try {
			int rowSize=10;
			int start=(rowSize*page)-rowSize;
			
			//cursor ==> RDBMS�� SELECT�� ���� ����
			DBCursor cursor=dbc.find().sort(new BasicDBObject("no", -1)).skip(start).limit(rowSize);
			
			while(cursor.hasNext()){
				BasicDBObject obj = (BasicDBObject) cursor.next();
				BoardVO vo = new BoardVO();
				vo.setNo(obj.getInt("no"));
				vo.setName(obj.getString("name"));
				vo.setSubject(obj.getString("subject"));
				vo.setRegdate(obj.getString("regdate"));
				vo.setHit(obj.getInt("hit"));
				list.add(vo);
			}
			cursor.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int boardTotalPage(){
		int total=0;
		
		try {
			DBCursor cursor = dbc.find();
			int count=cursor.count();
			
			total=(int)(Math.ceil(count/10.0));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return total;
	}
	
	public void boardInsert(BoardVO vo){
		try {
			DBCursor cursor = dbc.find();
			int no=0;
			while(cursor.hasNext()){
				BasicDBObject obj = (BasicDBObject) cursor.next();
				int bno=obj.getInt("no");
				if(bno>no)no=bno;
			}
			cursor.close();
			
			BasicDBObject insertObj = new BasicDBObject();
			insertObj.put("no", no+1);
			insertObj.put("name", vo.getName());
			insertObj.put("subject", vo.getSubject());
			insertObj.put("content", vo.getContent());
			insertObj.put("pwd", vo.getPwd());
			insertObj.put("regdate", vo.getRegdate());
			insertObj.put("hit", 0);
			
			dbc.insert(insertObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BoardVO boardContentData(int no){
		BoardVO vo=new BoardVO();
		try{
			BasicDBObject where=new BasicDBObject();
			
			where.put("no", no);
			//find({no : 1})
			
			BasicDBObject obj=(BasicDBObject) dbc.findOne(where);
			//SELECT * FROM board WHERE no=1;
			
			BasicDBObject updateObj=new BasicDBObject();
			updateObj.put("hit", obj.getInt("hit")+1);
			dbc.update(where, new BasicDBObject("$set", updateObj));
			//UPDATE board SET hit=hit+1 WHERE no=1;
			
			obj=(BasicDBObject) dbc.findOne(where);
			vo.setNo(obj.getInt("no"));
			vo.setSubject(obj.getString("subject"));
			vo.setName(obj.getString("name"));
			vo.setContent(obj.getString("content"));
			vo.setRegdate(obj.getString("regdate"));
			vo.setHit(obj.getInt("hit"));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return vo;
	}
	
	public BoardVO boardUpdateData(int no){
		BoardVO vo=new BoardVO();
		try{
			BasicDBObject where=new BasicDBObject();
			
			where.put("no", no);
			//find({no : 1})
			
			BasicDBObject obj=(BasicDBObject) dbc.findOne(where);
			//SELECT * FROM board WHERE no=1;
			
			vo.setNo(obj.getInt("no"));
			vo.setSubject(obj.getString("subject"));
			vo.setName(obj.getString("name"));
			vo.setContent(obj.getString("content"));
			vo.setRegdate(obj.getString("regdate"));
			vo.setHit(obj.getInt("hit"));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return vo;
	}
	
	public boolean boardUpdateOk(BoardVO vo){
		boolean bCheck=false;
		
		try{
			BasicDBObject where=new BasicDBObject();
			
			where.put("no", vo.getNo()); // Ư���� �� no�� ã�� ���� set
			
			BasicDBObject obj=(BasicDBObject) dbc.findOne(where); //no���� �����ϴ� �����͸� ã�ƶ�
			String db_pwd=obj.getString("pwd");
			
			if(db_pwd.equals(vo.getPwd())){
				BasicDBObject updateObj=new BasicDBObject();
				updateObj.put("name", vo.getName());
				updateObj.put("subject", vo.getSubject());
				updateObj.put("contet", vo.getContent());
				updateObj.put("hit", obj.getInt("hit")-2);
				dbc.update(where, new BasicDBObject("$set", updateObj)); //���ο� ������ set�� updateObj�� ������ ���� ������Ʈ
				bCheck=true;
			}else{
				bCheck=false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return bCheck;
	}
}






































