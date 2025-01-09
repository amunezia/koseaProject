package com.kosea.project.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UsersVO {

	private String userId;
	private String userPw;
	private String userPwRe;
	private String userName;
	private String phoneNum;
	private String email;
	private int verify;
	private Date regDate;
	private String resetToken;
	private Date tokenTime;
	
	public Date getTokenTime() {
		return tokenTime;
	}
	public void setTokenTime(Date tokenTime) {
		this.tokenTime = tokenTime;
	}
	public String getResetToken() {
		return resetToken;
	}
	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserPwRe() {
		return userPwRe;
	}
	public void setUserPwRe(String userPwRe) {
		this.userPwRe = userPwRe;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getVerify() {
		return verify;
	}
	public void setVerify(int verify) {
		this.verify = verify;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
