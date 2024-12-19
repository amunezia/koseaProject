package com.kosea.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kosea.project.service.BooksService;
import com.kosea.project.vo.BooksVO;

@Controller
public class BooksController {

    @Autowired
    private BooksService booksService;

    @GetMapping("/category/booksList")
    public String getBooksList(Model model) throws Exception{
        List<BooksVO> bookList = booksService.list();
        model.addAttribute("books", bookList); // JSPで使用するため、属性名を 'books' に変更
        return "category/booksList"; // このビューを返す
    }
}
