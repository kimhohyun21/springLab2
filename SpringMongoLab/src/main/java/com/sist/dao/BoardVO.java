package com.sist.dao;
/*
 * # ���� IT Ʈ����
 * 	1. Cloud Computing : ���ͳ� ��� ��ǻ�� ���
 *  
 *  2. ������
 * 		1) �帧 : SNS�� ����ϱ� �����ϸ鼭 ����� ���� ������ ����
 * 				==> �м� 
 * 				==> ����,����Ͻ� Ȱ��
 * 		2) Ư¡ : 3V (Volume(��), Velocity(�ӵ�), Variety(�پ缺)
 * 
 * 	3. ����Ʈ����
 * 		1) DB: RDBMS ==> NoSQL
 * 		2) ��� : SAS,SPSS ==> R
 * 	
 * # NoSQL(Not Only SQL) 
 * 	1. ���� ���
 * 		1) ������ ������ ���� �ý������δ� Ŀ�� �Ұ��� 
 * 			=> ���ο� ������ ������ ������ �䱸.
 *  2. ����
 *  	1) ���� RDBMS ������ ������ �����ͺ��̽�(���̺�,sql,Foreign Key,Join �� Ȱ��)�� �ƴ�
 *  	      �ٸ� ������ ���� ����� �ǹ���
 *  	2) key/value store ��� ==> Hbase,Cassandra
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


















