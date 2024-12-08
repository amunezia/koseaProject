package com.kosea.project.dao;

import com.kosea.project.vo.UsersVO;

public interface UsersDAO {

	int idCheck(UsersVO userId) throws Exception;
	
	void signup(UsersVO vo) throws Exception;
	
	UsersVO signin(UsersVO vo) throws Exception;
	
	UsersVO viewUserInfo(UsersVO vo)throws Exception;
}
