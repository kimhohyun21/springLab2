package com.sist.validation;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ValidationForm1 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotEmpty // ��� �ִ��� üũ
	@Size(min=1, max=20) //�ּ� 1~ �ִ� 20�� üũ
	private String name;
	
	@NotNull //null ���� �ƴ���
	@Max(50) // ������ 50�� ���� �ʴ��� üũ
	@Min(10) // ������ 10 �̻����� üũ
	private int age;

	@NotEmpty
	private String pwd;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
