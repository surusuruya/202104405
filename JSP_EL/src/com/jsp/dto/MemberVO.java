package com.jsp.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberVO {

	private String id;
	private String pwd;
	
	// 기본 생성자
	public MemberVO() {}
	
	// 생성자
	public MemberVO(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	
	// getter setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + "]";
	}
	
	
	public String getTime() {
		Date today = new Date();
		
		String todayStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(today);
		
		return todayStr;
	}
	
}
