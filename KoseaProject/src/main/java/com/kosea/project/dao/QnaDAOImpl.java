package com.kosea.project.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosea.project.vo.QnaReVO;
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
	public int count(String keyword,String searchType,String tag) throws Exception {
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("keyword", keyword);
		map.put("searchType", searchType);
		map.put("qna_tag", tag);
		return sql.selectOne(namespace+".count",map);
	}

	@Override
	public List<QnaVO> listPage(int num, int pageNumCnt,String keyword,String searchType,String tag) throws Exception {
		HashMap<String,Object> data=new HashMap<String,Object>();
		data.put("num", num);
		data.put("pageNumCnt", pageNumCnt);
		data.put("keyword", keyword);
		data.put("searchType", searchType);
		data.put("qna_tag", tag);
		return sql.selectList(namespace+".listPage",data);
	}

	@Override
	public void writeReply(QnaReVO rvo) throws Exception {
		sql.insert(namespace+".writeReply",rvo);
	}

	@Override
	public List<QnaReVO> replyList(int qna_no) throws Exception {
		return sql.selectList(namespace+".replyList",qna_no);
	}

	@Override
	public QnaReVO viewReply(QnaReVO rvo) throws Exception {
		return sql.selectOne(namespace+".viewReply",rvo);
	}
	
	@Override
	public void modifyReply(QnaReVO rvo) throws Exception {
		sql.update(namespace+".modifyReply",rvo);
	}
	
	@Override
	public void deleteReply(QnaReVO rvo) throws Exception {
		sql.delete(namespace+".deleteReply",rvo);
	}
	
}
