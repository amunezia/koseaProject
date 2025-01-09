package com.kosea.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kosea.project.service.AdminService;
import com.kosea.project.vo.UsersVO;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	private AdminService adminService;
	
	@GetMapping("/index")
    public String adminPage() {
        logger.info("관리자페이지입니다");
        return "admin/index";  
    }
	
	@GetMapping("/users/userlist")
	public String adminList(@RequestParam(value="currentPage",defaultValue = "1")int currentPage,
							@RequestParam(value="pageSize", defaultValue = "5")int pageSize, Model model)throws Exception {
		logger.info("관리자가 목록에 진입합니다");
		List<UsersVO> userList;
		int userCount;
		
		
		Map<String,Integer> params = new HashMap<>();
		params.put("start", (currentPage - 1) * pageSize); // ページングの開始位置
        params.put("pageSize", pageSize); // 1ページあたりの件数
        userList = adminService.getUserList(params);
        userCount = adminService.getUserCount();
        
        model.addAttribute("userList",userList);
        model.addAttribute("currentPage", currentPage); // 現在のページ
        model.addAttribute("pageSize", pageSize); // 1ページあたりの表示件数
        model.addAttribute("userCount",userCount);
        
        
        // 総ページ数を計算
        int totalPages = (int) Math.ceil((double) userCount / pageSize);
        model.addAttribute("totalPages", totalPages);
        
        
		return "admin/users/userlist";
	}
	
	@PostMapping("/users/delete")
	public String deleteUser(@RequestParam("userId")String userId,RedirectAttributes redirectAttributes)throws Exception{
		logger.info("유저삭제중",userId);
		if("admin".equals(userId)) {
			logger.warn("관리자는 삭제할수없습니다",userId);
			redirectAttributes.addFlashAttribute("alertMessage","관리자는 삭제 못합니다");
			return "redirect:/admin/users/userlist";
		}
		adminService.deleteUser(userId);
		redirectAttributes.addFlashAttribute("successMessage","회원이 정상적으로 삭제되었음");
		return "redirect:/admin/users/userlist";
	}
	

}
