package com.kosea.project.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosea.project.dao.UsersDAO;
import com.kosea.project.vo.UsersVO;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDAO dao;
	
	@Override
	public int idcheck(UsersVO userId) throws Exception {
			if(dao.idcheck(userId)==1) {
				return 1;
			} else {
					return 0;
			}
	}

	@Override
	public void signup(UsersVO vo) throws Exception {
			dao.signup(vo);
		
	}

	public void signupseller(UsersVO vo) throws Exception {
		dao.signupseller(vo);
	}
	
	@Override
	public UsersVO signin(UsersVO vo) throws Exception {
			return dao.signin(vo);
	}

	@Override
	public UsersVO viewUserInfo(UsersVO vo) throws Exception {
		return dao.viewUserInfo(vo);
	}

	@Override
	public String findidByPhone(UsersVO vo) throws Exception {
		return dao.findidByPhone(vo);
	}

	@Override
	public String findidByEmail(UsersVO vo) throws Exception {
		return dao.findidByEmail(vo);
	}

	@Override
	public String findpw(UsersVO vo) throws Exception {
			return dao.findpw(vo);
	}
	//기존 비밀번호찾기후 변경
	@Override
	public boolean updatePw(String userId, String userPw, String userPwRe)throws Exception{
		return dao.updatePw(userId, userPw, userPwRe); 
	}
	
	@Override
    public boolean resetPw(String token, String userPw, String userPwRe) throws Exception {

        UsersVO user = dao.getUserByToken(token);
        
        if (user != null && user.getTokenTime().after(new Date())) {

            boolean o =dao.updatePw(user.getUserId(), userPw, userPwRe);
            
            if(o) {
            dao.deleteResetToken(user.getUserId());
         
            return true;
            }
        } 
            return false;   
	}
	
	@Override
	public UsersVO getUserByToken(String token) throws Exception {
		return dao.getUserByToken(token);
	}
}