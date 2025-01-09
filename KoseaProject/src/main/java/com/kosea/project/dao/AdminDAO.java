package com.kosea.project.dao;

import java.util.List;
import java.util.Map;

import com.kosea.project.vo.UsersVO;

public interface AdminDAO {
	public void deleteUser(String userId)throws Exception;
	List<UsersVO> getUserList(Map<String, Integer> params) throws Exception;
	public int getUserCount() throws Exception;
	
}
