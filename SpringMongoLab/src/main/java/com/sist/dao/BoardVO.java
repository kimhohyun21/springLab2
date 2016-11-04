package com.sist.dao;
/*
 * cloud computing 
 * 	- ���ͳ� ��� ��ǻ�� ���
 * ������
 * 	- SNS, ����� ���� ������ => �м� => ����,����Ͻ� Ȱ��
 * 	- Ư¡ : 3V (Volume,Velocity,Variety)
 * ����Ʈ����
 * 	- RDBMS => NoSQL
 * 	- SAS,SPSS => R
 * 	
 * NoSQL(Not Only SQL) ���� ���
 * 	- ������ ������ ���� �ý������δ� Ŀ�� �Ұ��� => ���ο� ������ ������ ������ �䱸.
 * NoSQL
 * 	- ���� RDBMS ������ ������ �����ͺ��̽��� �ƴ�  (���̺�,sql,Foreign Key,Join)
 * 	  �ٸ� ������ ���� ����� �ǹ���. (key/value store)-Hbase,Cassandra
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


















