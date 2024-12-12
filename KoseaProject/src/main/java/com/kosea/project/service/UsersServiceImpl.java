package com.kosea.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosea.project.dao.UsersDAO;
import com.kosea.project.vo.UsersVO;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDAO dao;
	
	@Override
	public int idCheck(UsersVO userId) throws Exception {
			if(dao.idCheck(userId)==1) {
				return 1;
			} else {
					return 0;
			}
	}

	@Override
	public void signup(UsersVO vo) throws Exception {
			dao.signup(vo);
		
	}

	@Override
	public UsersVO signin(UsersVO vo) throws Exception {
			return dao.signin(vo);
	}

	@Override
	public UsersVO viewUserInfo(UsersVO vo) throws Exception {
		return dao.viewUserInfo(vo);
	}
}