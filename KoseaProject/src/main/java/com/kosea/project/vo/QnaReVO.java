package com.kosea.project.vo;

import java.util.Date;

public class QnaReVO {

	private int qna_no;
	private int qna_rno;
	private String userId;
	private String qna_rcontent;
	private Date qna_date;
	
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public int getQna_rno() {
		return qna_rno;
	}
	public void setQna_rno(int qna_rno) {
		this.qna_rno = qna_rno;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getQna_rcontent() {
		return qna_rcontent;
	}
	public void setQna_rcontent(String qna_rcontent) {
		this.qna_rcontent = qna_rcontent;
	}
	public Date getQna_date() {
		return qna_date;
	}
	public void setQna_date(Date qna_date) {
		this.qna_date = qna_date;
	}
}
