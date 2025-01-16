package com.kosea.project.dao;

import java.util.Date;

import com.kosea.project.vo.UsersVO;

public interface UsersDAO {

	int idcheck(UsersVO userId) throws Exception;
	
	void signup(UsersVO vo) throws Exception;
	
	void signupseller(UsersVO vo) throws Exception;
	
	UsersVO signin(UsersVO vo) throws Exception;
	
	UsersVO viewUserInfo(UsersVO vo)throws Exception;
	
	String findidByPhone(UsersVO vo)throws Exception;
	
	String findidByEmail(UsersVO vo)throws Exception;
	
	String findpw(UsersVO email)throws Exception;
	
	boolean updatePw(String userId, String userPw, String userPwRe)throws Exception;
	
	UsersVO getUserByToken(String token) throws Exception;
	
	public void saveResetToken(String userId, String token, Date time) throws Exception;
	 
	public void deleteResetToken(String userId) throws Exception;
}
