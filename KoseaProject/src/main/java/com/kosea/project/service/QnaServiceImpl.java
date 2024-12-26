package com.kosea.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosea.project.dao.QnaDAO;
import com.kosea.project.vo.QnaVO;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public void write(QnaVO vo) throws Exception {
		qnaDAO.write(vo);
	}

	@Override
	public List<QnaVO> list() throws Exception {
		return qnaDAO.list();
	}

	@Override
	public QnaVO view(int qna_no) throws Exception {
		return qnaDAO.view(qna_no);
	}

	@Override
	public void delete(int qna_no) throws Exception {
		qnaDAO.delete(qna_no);
	}

	@Override
	public void modify(QnaVO vo) throws Exception {
		qnaDAO.modify(vo);
	}

	@Override
	public int count() throws Exception {
		return qnaDAO.count();
	}

	@Override
	public List<QnaVO> listPage(int num, int pageNumCnt) throws Exception {
		return qnaDAO.listPage(num,pageNumCnt);
	}

}