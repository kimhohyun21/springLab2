package com.sist.trigger;

public class InputVO {
	private int 입고번호;
	private String 상품코드;
	private String 입고일자;
	private int 입고수량;
	private int 입고단가;
	private int 입고금액;
	
	public int get입고번호() {
		return 입고번호;
	}
	public void set입고번호(int 입고번호) {
		this.입고번호 = 입고번호;
	}	
	public String get상품코드() {
		return 상품코드;
	}
	public void set상품코드(String 상품코드) {
		this.상품코드 = 상품코드;
	}
	public String get입고일자() {
		return 입고일자;
	}
	public void set입고일자(String 입고일자) {
		this.입고일자 = 입고일자;
	}
	public int get입고수량() {
		return 입고수량;
	}
	public void set입고수량(int 입고수량) {
		this.입고수량 = 입고수량;
	}
	public int get입고단가() {
		return 입고단가;
	}
	public void set입고단가(int 입고단가) {
		this.입고단가 = 입고단가;
	}
	public int get입고금액() {
		return 입고금액;
	}
	public void set입고금액(int 입고금액) {
		this.입고금액 = 입고금액;
	}
}
