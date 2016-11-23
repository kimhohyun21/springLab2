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
	
	@NotEmpty // 비어 있는지 체크
	@Size(min=1, max=20) //최소 1~ 최대 20자 체크
	private String name;
	
	@NotNull //null 값이 아닌지
	@Max(50) // 범위가 50을 넘지 않는지 체크
	@Min(10) // 범위가 10 이상인지 체크
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
