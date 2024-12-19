package com.kosea.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosea.project.dao.BooksDAO;
import com.kosea.project.vo.BooksVO;

@Service
public class BooksServiceImpl implements BooksService {
	
	@Autowired
	private BooksDAO booksDAO;
	
	@Override
	public List<BooksVO> list() throws Exception {
	    return booksDAO.list();
	}
}
