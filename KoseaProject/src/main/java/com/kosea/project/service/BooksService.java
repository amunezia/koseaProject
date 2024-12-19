package com.kosea.project.service;

import java.util.List;

import com.kosea.project.vo.BooksVO;

public interface BooksService {
    List<BooksVO> list() throws Exception;
}
