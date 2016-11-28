package com.sist.procedure;
import java.sql.*;

import oracle.jdbc.driver.OracleTypes;

public class MainClass {
	public static void main(String[] args){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@211.238.142.88:1521:ORCL";
			String username="scott";
			String password="tiger";
			Connection conn=DriverManager.getConnection(url,username,password);
			String sql=null;
			CallableStatement cs;
			PreparedStatement ps;
			ResultSet rs;
			
			sql="{CALL addrInsert(?,?,?,?)}";
			cs=conn.prepareCall(sql);
			cs.setString(1, "김호현");
			cs.setString(2, "서울");
			cs.setString(3, "010-3860-7688");
			cs.setString(4, "남");
			cs.executeUpdate();
			cs.close();
			System.out.println("저장 완료");
			
			/*//procedure에 사용한 코드 확인
			String sql="SELECT text FROM user_source WHERE name='ADDRINSERT'"; 
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				String text=rs.getString(1);
				System.out.println(text);
			}
			rs.close();*/
			
			sql="{CALL addrAllData(?)}";
			cs=conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.executeUpdate(); 
			rs=(ResultSet) cs.getObject(1);		
			while(rs.next()){
				System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
