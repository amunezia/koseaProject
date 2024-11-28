package com.kosea.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String mainPage() {
        return "index";  // /WEB-INF/views/index.jsp로 리턴
    }
}
