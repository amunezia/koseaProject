package com.kosea.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosea.project.vo.BooksVO;

@Repository
public class BooksDAOImpl implements BooksDAO {
    
	@Autowired
	private SqlSessionTemplate sql;
	
	
	private String namespace="com.kosea.project.mappers.BooksMapper";

	@Override
	public List<BooksVO> list() throws Exception {
	    return sql.selectList(namespace + ".list");
	}


}
