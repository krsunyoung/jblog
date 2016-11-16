package com.bit2016.jblog.vo;

public class CommentsVo {
	
	private Long no;
	private String content;
	private String reg_date;
	private Long post_no;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public Long getPost_no() {
		return post_no;
	}
	public void setPost_no(Long post_no) {
		this.post_no = post_no;
	}
	@Override
	public String toString() {
		return "CommentsVo [no=" + no + ", content=" + content + ", reg_date=" + reg_date + ", post_no=" + post_no
				+ "]";
	}
	
	
}
