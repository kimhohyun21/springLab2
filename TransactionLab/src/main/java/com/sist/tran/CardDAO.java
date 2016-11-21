package com.sist.tran;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;

public class CardDAO extends JdbcDaoSupport{
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void cardInsert(String id, int won){
		String sql="INSERT INTO card "
				+ "VALUES((SELECT NVL(MAX(no)+1,1) FROM card),?,?)";
		getJdbcTemplate().update(sql, id, won);	
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	public void pointInsert(String id, int won){
		String sql="INSERT INTO point "
				+ "VALUES((SELECT NVL(MAX(no)+1,1) FROM point),?,?)";
		int point=won/10;
		getJdbcTemplate().update(sql, id, point);	
	}
	
	public void insert(String id, int won){
		cardInsert(id, won);
		pointInsert(id, won);
	}
}
