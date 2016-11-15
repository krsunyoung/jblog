package com.bit2016.jblog.vo;

public class BlogVo {
	
	private long users_no;
	private String title;
	private String logo;
	
	
	public long getUsers_no() {
		return users_no;
	}
	public void setUsers_no(long users_no) {
		this.users_no = users_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	@Override
	public String toString() {
		return "BlogVo [users_no=" + users_no + ", title=" + title + ", logo=" + logo + "]";
	}
	
	
}
