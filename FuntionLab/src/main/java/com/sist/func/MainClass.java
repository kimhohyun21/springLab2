package com.sist.func;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainClass {
	public static void main(String[] args) {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@211.238.142.88:1521:ORCL";
			Connection conn=DriverManager.getConnection(url,"scott","tiger");
			String sql="SELECT DISTINCT deptno, pkg_emp.empCount(deptno), pkg_emp.empSum(deptno), pkg_emp.empAvg(deptno) FROM emp";
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+" "+rs.getDouble(4));			
			}
			rs.close();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
