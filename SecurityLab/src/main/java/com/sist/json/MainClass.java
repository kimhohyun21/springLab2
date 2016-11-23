package com.sist.json;
/*
 * #Spring에서 정리해두어야 할 개념
 * 	1. Framework(Framework VS Library)
 * 		=> 레고 / 완제품
 * 	2. Container : 클래스 관리자 (컴포넌트)
 * 		=> 경량 컨테이너
 * 			DI
 * 			AOP : security, Transaction
 * 			WEB
 * 			ORM, JDBC
 * 			==> 제어 : XML, Annotation
 * 
 * #Java에서 정리해두어야 할 개념 
 * 	1. 데이터형(데이터형 변환) : static VS instance
 * 	2. 연산자, 제어문
 * 	3. 메서드
 * 	4. 객체 : 멤버변수, 멤버메서드, 생성자
 * 	5. OOP
 * 		1) 캡슐화
 * 		2) 상속
 * 		3) 다형성(오버라이딩, 오버로딩)
 * 	6. 예외처리
 * 	7. 컬렉션 클래스
 * 	8. IO
 * 
 * #오라클에서 정리해두어야 할 개념
 * 	1. DML : select, insert, update, delete
 * 				=> join, subQuery
 * 	2. DDL : create, alter, drop
 * 				=> VIEW, PROCEDURE, TRIGGER, TABLE
 * 	3. TCL : commit, rollback
 * 	4. DCL : grant, revoke
 * 
 * #JSP에서 정리해두어야 할 개념
 *	1. 지시자 : page, taglib,include (@include, jsp: include)
 *	2. 예외처리 : page ==> errorPage,web.xml
 *	3. MVC : Model, View, Controller
 * 
 * #웹 모의 해킹, 시큐어 코딩 ==> 담주 
 * 
 */
import org.json.simple.*;
import java.io.*;
import java.net.*;

public class MainClass {
	public static void main(String[] args) {
		try{
			JSONObject obj=new JSONObject();
			String name="감동훈";
			URLEncoder.encode(name, "EUC-KR");
			obj.put("name", name);
			obj.put("age", 30);
			
			String gender="남자";
			URLEncoder.encode(gender, "EUC-KR");
			obj.put("gender", gender);
			
			JSONArray list=new JSONArray();
			list.add("010-3860-7688");
			list.add("010-3490-7270");
			list.add("010-1245-2388");
			
			obj.put("phone", list);
			
			FileOutputStream file=new FileOutputStream("./info.json");
			file.write(obj.toJSONString().getBytes("EUC-KR"));
			file.flush();
			file.close();
			
			System.out.println("저장완료");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
