package com.kosea.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value="/")
    public String mainPage() {
        return "index";  // /WEB-INF/views/index.jsp로 리턴
    }
    
    //Q&A페이지 이동
    @GetMapping(value="/qna/qna")
    public void qna() throws Exception{
    }


}
