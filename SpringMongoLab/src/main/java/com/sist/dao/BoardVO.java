package com.sist.dao;
/*
 * # 현재 IT 트렌드
 * 	1. Cloud Computing : 인터넷 기반 컴퓨팅 기술
 *  
 *  2. 빅데이터
 * 		1) 흐름 : SNS를 사용하기 시작하면서 방대한 양의 데이터 생성
 * 				==> 분석 
 * 				==> 예측,비즈니스 활용
 * 		2) 특징 : 3V (Volume(양), Velocity(속도), Variety(다양성)
 * 
 * 	3. 소프트웨어
 * 		1) DB: RDBMS ==> NoSQL
 * 		2) 통계 : SAS,SPSS ==> R
 * 	
 * # NoSQL(Not Only SQL) 
 * 	1. 등장 배경
 * 		1) 기존의 데이터 저장 시스템으로는 커버 불가능 
 * 			=> 새로운 형태의 데이터 저장기술 요구.
 *  2. 개념
 *  	1) 기존 RDBMS 형태의 관계형 데이터베이스(테이블,sql,Foreign Key,Join 등 활용)가 아닌
 *  	      다른 형태의 저장 기술을 의미함
 *  	2) key/value store 방식 ==> Hbase,Cassandra
 *
 */
public class BoardVO {
	private int no;
	private String name;
	private String subject;
	private String content;
	private String regdate;
	private String pwd;
	private int hit;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
}


















