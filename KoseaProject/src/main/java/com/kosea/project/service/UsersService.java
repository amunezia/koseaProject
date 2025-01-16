package com.kosea.project.service;

import com.kosea.project.vo.UsersVO;

public interface UsersService {

	int idcheck(UsersVO userId) throws Exception;
	
	void signup(UsersVO vo) throws Exception;
	
	void signupseller(UsersVO vo) throws Exception ;
	
	UsersVO signin(UsersVO vo) throws Exception;
	
	UsersVO viewUserInfo(UsersVO vo)throws Exception;
	
	String findidByPhone(UsersVO vo)throws Exception;
	
	String findidByEmail(UsersVO vo)throws Exception;
	
	String findpw(UsersVO vo) throws Exception;
	
	boolean updatePw(String userId, String userPw, String userPwRe)throws Exception;
	
	boolean resetPw(String token, String userPw, String userPwRe) throws Exception ;
	
	UsersVO getUserByToken(String token) throws Exception;
}
