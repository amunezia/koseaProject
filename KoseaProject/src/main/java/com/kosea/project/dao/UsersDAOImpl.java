package com.kosea.project.dao;

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
	public int idCheck(UsersVO userId) throws Exception {
		return sql.selectOne(namespace+".idCheck",userId);
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

	
}
