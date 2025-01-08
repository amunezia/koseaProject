package com.kosea.project.service;

import java.util.List;
import java.util.Map;

import com.kosea.project.vo.UsersVO;

public interface AdminService {
	void deleteUser(String userId)throws Exception;
	List<UsersVO>getUserList(Map<String,Integer>params)throws Exception;
	int getUserCount()throws Exception;

}
