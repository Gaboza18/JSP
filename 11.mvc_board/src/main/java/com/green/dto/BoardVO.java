package com.green.dto;

import java.sql.Timestamp;

public class BoardVO {

	private int num; // �Խ��� �Ϸù�ȣ
	private String name; // �ۼ���
	private String email; // �ۼ��� �̸���
	private String pass; // �Խñ� ��й�ȣ(�Խñ� ����, ������ �ʿ�)
	private String title; // �Խñ� ����
	private String content; // �Խñ� ����
	private int readcount; // �Խñ� ��ȸ ��
	private Timestamp writedate; // �Խñ� �ۼ���

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public Timestamp getWritedate() {
		return writedate;
	}

	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}

	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", name=" + name + ", email=" + email + ", pass=" + pass + ", title=" + title
				+ ", content=" + content + ", readcount=" + readcount + ", writedata=" + writedate + "]";
	}

}