package com.ev.vo;

import java.util.Date;

public class UserVO {
	private int num;
	private String id;
	private String pw;
	private String email;
	private String tel;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Date getRegdata() {
		return regdata;
	}
	public void setRegdata(Date regdata) {
		this.regdata = regdata;
	}
	private String addr;
	private Date regdata;
}
