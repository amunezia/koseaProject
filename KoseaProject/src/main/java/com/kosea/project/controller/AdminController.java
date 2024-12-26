package com.kosea.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kosea.project.vo.UsersVO;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@GetMapping("/index")
    public String adminPage() {
        logger.info("관리자페이지입니다");
        return "admin/index";  
    }
	
	@GetMapping("/users/list")
	public String adminList() {
		logger.info("관리자가 목록에 진입합니다");
		List<UsersVO> usersList;
		return "admin/users/list";
		
	}
	

}
