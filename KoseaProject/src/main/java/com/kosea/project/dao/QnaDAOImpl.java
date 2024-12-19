package com.kosea.project.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosea.project.vo.QnaVO;
@Repository
public class QnaDAOImpl implements QnaDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	
	private String namespace="com.kosea.project.mappers.QnaMapper";

	//질문작성
	@Override
	public void write(QnaVO vo) throws Exception {
		sql.insert(namespace+".write",vo);
	}

	@Override
	public List<QnaVO> list() throws Exception {
		return sql.selectList(namespace+".list");
	}

	@Override
	public QnaVO view(int qna_no) throws Exception {
		return sql.selectOne(namespace+".view",qna_no);
	}

	@Override
	public void delete(int qna_no) throws Exception {
		sql.delete(namespace+".delete",qna_no);
	}

	@Override
	public void modify(QnaVO vo) throws Exception {
		sql.update(namespace+".modify",vo);
	}

	@Override
	public int count() throws Exception {
		return sql.selectOne(namespace+".count");
	}

	@Override
	public List<QnaVO> listPage(int displayPost, int postNum) throws Exception {
		HashMap<String,Integer> data=new HashMap<String,Integer>();
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		return sql.selectList(namespace+".listPage",data);
	}
	
}
