package com.kosea.project.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kosea.project.vo.UsersVO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	
	@Inject
	private SqlSession sql;
	
	private static String namespace ="com.kosea.project.mappers.AdminMapper";

	@Override
	public void deleteUser(String userId) throws Exception {
		sql.delete(namespace+".deleteUser",userId);

	}

	@Override
	public List<UsersVO> getUserList(Map<String,Integer>params) throws Exception {
		
		return sql.selectList(namespace+".getUserList",params);
	}

	@Override
	public int getUserCount() throws Exception {
		
		return sql.selectOne(namespace+".getUserCount");
	}

}
