package com.kosea.project.dao;

import com.kosea.project.vo.UsersVO;

public interface UsersDAO {

	int idcheck(UsersVO userId) throws Exception;
	
	void signup(UsersVO vo) throws Exception;
	
	UsersVO signin(UsersVO vo) throws Exception;
	
	UsersVO viewUserInfo(UsersVO vo)throws Exception;
	
	String findidByPhone(UsersVO vo)throws Exception;
	
	String findidByEmail(UsersVO vo)throws Exception;
	
	String findpw(UsersVO email)throws Exception;
	
	boolean updatePw(String userId, String userPw, String userPwRe)throws Exception;
}
