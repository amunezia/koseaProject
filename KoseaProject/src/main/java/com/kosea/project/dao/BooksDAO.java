package com.kosea.project.dao;

import java.util.List;

import com.kosea.project.vo.BooksVO;

public interface BooksDAO {
	List<BooksVO> list() throws Exception;

}
