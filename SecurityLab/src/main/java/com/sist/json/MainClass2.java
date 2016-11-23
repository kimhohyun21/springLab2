package com.sist.json;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.*;
import java.util.Iterator;

// {} JSONObject [] JSONArray
public class MainClass2 {
	public static void main(String[] args) {
		try{
			
			JSONParser p=new JSONParser();
			Object obj=p.parse(new InputStreamReader(new FileInputStream("./info.json"), "EUC-KR"));
			JSONObject jsonObj=(JSONObject) obj;
			
			String name=(String) jsonObj.get("name");
			System.out.println("name :"+name);
			
			long age=(Long) jsonObj.get("age");
			System.out.println("age :"+age);
			
			String gender=(String) jsonObj.get("gender");
			System.out.println("gender :"+gender);
			
			JSONArray phone=(JSONArray) jsonObj.get("phone");
			Iterator<String> i=phone.iterator(); // jsonArray 값을 받아오는 메서드
			String phone2="";
			while(i.hasNext()){
				phone2+=i.next()+",";
			}
			phone2=phone2.substring(0, phone2.lastIndexOf(","));		
			System.out.println("phone :"+phone2);
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
