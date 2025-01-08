package com.kosea.project.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kosea.project.dao.AdminDAO;
import com.kosea.project.vo.UsersVO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Inject
	private AdminDAO dao;

	@Override
	public void deleteUser(String userId) throws Exception {
		dao.deleteUser(userId);

	}

	@Override
	public List<UsersVO> getUserList(Map<String, Integer> params) throws Exception {
		// TODO Auto-generated method stub
		return dao.getUserList(params);
	}

	@Override
	public int getUserCount() throws Exception {
		
		return dao.getUserCount();
	}

}
