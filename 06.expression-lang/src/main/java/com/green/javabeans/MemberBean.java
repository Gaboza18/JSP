package com.green.javabeans;

// 자바 빈 생성연습

public class MemberBean {

	private String userid;
	private String name;
	
	public MemberBean() {
		
	}
	
	public MemberBean(String userid, String name) {
		this.userid = userid;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "MemberBean [userid=" + userid + ", name=" + name + "]";
	}

}
