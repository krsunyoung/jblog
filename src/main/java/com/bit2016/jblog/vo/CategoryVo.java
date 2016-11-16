package com.bit2016.jblog.vo;


public class CategoryVo {

	private Long no;
	private Long users_no;
	private String name;
	private String description;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getUsers_no() {
		return users_no;
	}
	public void setUsers_no(Long users_no) {
		this.users_no = users_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", users_no=" + users_no + ", name=" + name + ", description=" + description
				+ "]";
	}
	
	
}
