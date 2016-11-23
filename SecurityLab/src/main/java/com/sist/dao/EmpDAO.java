package com.sist.dao;

import java.io.FileInputStream;
import java.sql.*;
import java.util.*;

public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String driver;
	private Properties prop=new Properties();
	
	public EmpDAO(){
		try{
			prop.load(new FileInputStream("./db.properties"));
			driver=prop.getProperty("db.driver");
			Class.forName(driver);			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}	
	
	//Before ==> AOP
	public void getConnection(){
		try{
			conn=DriverManager.getConnection(prop.getProperty("db.url"), prop.getProperty("db.user"), prop.getProperty("db.pwd"));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	//After
	public void disConnection(){
		try{
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public List<EmpVO> empAllData(){
		List<EmpVO> list=new ArrayList<EmpVO>();
		try{
			getConnection();
			
			String sql="SELECT empno, ename, job, hiredate, sal "
					+ "FROM $tablename";
			sql=sql.replace("$tablename", prop.getProperty("db.table"));
			ps=conn.prepareStatement(sql);			
			rs=ps.executeQuery();
			
			while(rs.next()){
				EmpVO vo=new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.setSal(rs.getInt(5));
				
				list.add(vo);
			}
			rs.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			disConnection();
		}
		
		return list;
	}
}
