package com.kosea.project.dao;

import java.util.List;

import com.kosea.project.vo.QnaReVO;
import com.kosea.project.vo.QnaVO;

public interface QnaDAO {

	void write(QnaVO vo) throws Exception;
	
	List<QnaVO> list() throws Exception;
	
	QnaVO view(int qna_no) throws Exception;
	
	void delete(int qna_no) throws Exception;
	
	void modify(QnaVO vo) throws Exception;
	
	int count(String keyword,String searchType,String tag) throws Exception;
	
	List<QnaVO> listPage(int num,int pageNumCnt,String keyword,String searchType,String tag) throws Exception;
	
	void writeReply(QnaReVO rvo) throws Exception;
	
	List<QnaReVO> replyList(int qna_no) throws Exception;
	
	QnaReVO viewReply(QnaReVO rvo) throws Exception;
	
	void modifyReply(QnaReVO rvo) throws Exception;
	
	void deleteReply(QnaReVO rvo) throws Exception;
}
