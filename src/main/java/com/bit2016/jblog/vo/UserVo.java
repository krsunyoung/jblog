package com.bit2016.jblog.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class UserVo {
	
	private long no;
	@NotEmpty
	@Length(min=2, max=20)
	private String id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String password;
	private String reg_date;
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", id=" + id + ", name=" + name + ", password=" + password + ", reg_date="
				+ reg_date + "]";
	}
	
	
	
}
