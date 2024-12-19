package com.kosea.project.service;

import com.kosea.project.vo.UsersVO;

public interface UsersService {

	int idcheck(UsersVO userId) throws Exception;
	
	void signup(UsersVO vo) throws Exception;
	
	UsersVO signin(UsersVO vo) throws Exception;
	
	UsersVO viewUserInfo(UsersVO vo)throws Exception;
	
	String findidByPhone(UsersVO vo)throws Exception;
	
	String findidByEmail(UsersVO vo)throws Exception;
	
	UsersVO findpw(UsersVO vo)throws Exception;
	
}
