package com.kosea.project.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosea.project.vo.UsersVO;

@Repository
public class UsersDAOImpl implements UsersDAO{

	@Autowired
	private SqlSessionTemplate sql;
	private static String namespace="com.kosea.project.mappers.UsersMapper";
	
	@Override
	public int idcheck(UsersVO userId) throws Exception {
		return sql.selectOne(namespace+".idcheck",userId);
	}

	@Override
	public void signup(UsersVO vo) throws Exception {
		sql.insert(namespace+".signup",vo);
	}

	@Override
	public UsersVO signin(UsersVO vo) throws Exception {
		return sql.selectOne(namespace+".signin",vo);
	}

	@Override
	public UsersVO viewUserInfo(UsersVO vo) throws Exception {
		return sql.selectOne(namespace+".viewUserInfo",vo);
	}

	@Override
	public String findidByPhone(UsersVO vo) throws Exception {
		return sql.selectOne(namespace+".findidByPhone", vo);
	}

	@Override
	public String findidByEmail(UsersVO vo) throws Exception {
		return sql.selectOne(namespace+".findidByEmail", vo);
	}

	@Override
	public String findpw(UsersVO vo) throws Exception {
		return sql.selectOne(namespace+".findpw", vo);
	}

	@Override
	public boolean updatePw(String userId, String userPw, String userPwRe)throws Exception{
		Map<String, Object> uppw = new HashMap<>();
		uppw.put("userId", userId);
		uppw.put("userPw", userPw);
		uppw.put("userPwRe", userPwRe);
		
		int result = sql.update(namespace + ".updatePw", uppw);	
		return result > 0 ;
	}
	
    @Override
    public UsersVO getUserByToken(String token) throws Exception {
        return sql.selectOne(namespace + ".getUserByToken", token);
    }
    
    @Override
    public void saveResetToken(String userId, String token, Date time) throws Exception {
        Map<String, Object> saveToken = new HashMap<>();
        saveToken.put("userId", userId);
        saveToken.put("resetToken", token);
        saveToken.put("tokenTime", time);
        
        sql.update(namespace + ".saveResetToken", saveToken);
    }

    // 비밀번호 재설정 후 토큰 삭제
    @Override
    public void deleteResetToken(String userId) throws Exception {
        sql.update(namespace + ".deleteResetToken", userId);
    }
	
}
