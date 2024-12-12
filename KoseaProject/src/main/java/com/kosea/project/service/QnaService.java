package com.kosea.project.service;

import java.util.List;

import com.kosea.project.vo.QnaVO;

public interface QnaService {

	void write(QnaVO vo) throws Exception;
	
	List<QnaVO> list() throws Exception;
	
	QnaVO view(int qna_no) throws Exception;

	void delete(int qna_no) throws Exception;
	
	void modify(QnaVO vo) throws Exception;
}
