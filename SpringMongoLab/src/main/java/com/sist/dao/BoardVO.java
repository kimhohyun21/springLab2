package com.sist.dao;
/*
 * cloud computing 
 * 	- 인터넷 기반 컴퓨팅 기술
 * 빅데이터
 * 	- SNS, 방대한 양의 데이터 => 분석 => 예측,비즈니스 활용
 * 	- 특징 : 3V (Volume,Velocity,Variety)
 * 소프트웨어
 * 	- RDBMS => NoSQL
 * 	- SAS,SPSS => R
 * 	
 * NoSQL(Not Only SQL) 등장 배경
 * 	- 기존의 데이터 저장 시스템으로는 커버 불가능 => 새로운 형태의 데이터 저장기술 요구.
 * NoSQL
 * 	- 기존 RDBMS 형태의 관계형 데이터베이스가 아닌  (테이블,sql,Foreign Key,Join)
 * 	  다른 형태의 저장 기술을 의미함. (key/value store)-Hbase,Cassandra
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


















