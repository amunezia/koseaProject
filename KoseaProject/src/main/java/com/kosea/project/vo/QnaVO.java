package com.kosea.project.vo;

import java.util.Date;

public class QnaVO {
	private int qna_no;
	private String qna_title;
	private String qna_content;
	private String qna_writer;
	private Date qna_date;
	
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public String getQna_writer() {
		return qna_writer;
	}
	public void setQna_writer(String qna_writer) {
		this.qna_writer = qna_writer;
	}
	public Date getQna_date() {
		return qna_date;
	}
	public void setQna_date(Date qna_date) {
		this.qna_date = qna_date;
	}
	
	//ページ
	private int num;
	private int count;
	private int postNum=10;
	private int pageNum;
	private int displayPost;
	private int pageNumCnt=10;
	private int endPageNum;
	private int startPageNum;
	private boolean prev;
	private boolean next;
	
	//ページ
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		pagenation();
	}
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getDisplayPost() {
		return displayPost;
	}
	public void setDisplayPost(int displayPost) {
		this.displayPost = displayPost;
	}
	public int getPageNumCnt() {
		return pageNumCnt;
	}
	public void setPageNumCnt(int pageNumCnt) {
		this.pageNumCnt = pageNumCnt;
	}
	public int getEndPageNum() {
		return endPageNum;
	}
	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}
	public int getStartPageNum() {
		return startPageNum;
	}
	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	private void pagenation() {
		startPageNum=((int)Math.ceil((double)((num-1)/pageNumCnt)))*pageNumCnt+1;
		endPageNum=startPageNum+pageNumCnt-1;
			
		pageNum=(int)Math.ceil((double)count/postNum);
		if(endPageNum>pageNum) {
			endPageNum=pageNum;
		}
		if(num>pageNum) {
			num=pageNum;
		}
		
		prev=startPageNum==1?false:true;
		next=endPageNum*pageNumCnt>=count?false:true;
		
		displayPost=(num-1)*postNum;
	}
}
