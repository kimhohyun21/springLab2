package com.sist.json;
/*
 * #Spring���� �����صξ�� �� ����
 * 	1. Framework(Framework VS Library)
 * 		=> ���� / ����ǰ
 * 	2. Container : Ŭ���� ������ (������Ʈ)
 * 		=> �淮 �����̳�
 * 			DI
 * 			AOP : security, Transaction
 * 			WEB
 * 			ORM, JDBC
 * 			==> ���� : XML, Annotation
 * 
 * #Java���� �����صξ�� �� ���� 
 * 	1. ��������(�������� ��ȯ) : static VS instance
 * 	2. ������, ���
 * 	3. �޼���
 * 	4. ��ü : �������, ����޼���, ������
 * 	5. OOP
 * 		1) ĸ��ȭ
 * 		2) ���
 * 		3) ������(�������̵�, �����ε�)
 * 	6. ����ó��
 * 	7. �÷��� Ŭ����
 * 	8. IO
 * 
 * #����Ŭ���� �����صξ�� �� ����
 * 	1. DML : select, insert, update, delete
 * 				=> join, subQuery
 * 	2. DDL : create, alter, drop
 * 				=> VIEW, PROCEDURE, TRIGGER, TABLE
 * 	3. TCL : commit, rollback
 * 	4. DCL : grant, revoke
 * 
 * #JSP���� �����صξ�� �� ����
 *	1. ������ : page, taglib,include (@include, jsp: include)
 *	2. ����ó�� : page ==> errorPage,web.xml
 *	3. MVC : Model, View, Controller
 * 
 * #�� ���� ��ŷ, ��ť�� �ڵ� ==> ���� 
 * 
 */
import org.json.simple.*;
import java.io.*;
import java.net.*;

public class MainClass {
	public static void main(String[] args) {
		try{
			JSONObject obj=new JSONObject();
			String name="������";
			URLEncoder.encode(name, "EUC-KR");
			obj.put("name", name);
			obj.put("age", 30);
			
			String gender="����";
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
			
			System.out.println("����Ϸ�");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
