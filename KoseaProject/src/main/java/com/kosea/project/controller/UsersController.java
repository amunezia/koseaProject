package com.kosea.project.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kosea.project.service.UsersService;
import com.kosea.project.util.Utils;
import com.kosea.project.vo.UsersVO;

@Controller
public class UsersController {

	@Inject
	private UsersService service;

	@GetMapping(value="/users/signin")
	public void getSignin() throws Exception{
	}
    
    @GetMapping(value="/users/signup")
	public void getSignup() throws Exception{
    }
 
    
    //ID중복체크
	@PostMapping(value="/idcheck", produces="application/json")
	public ResponseEntity<Integer> idcheck(@RequestBody UsersVO userId) throws Exception{
		
		int checkedId=service.idcheck(userId);
		return ResponseEntity.ok().body(checkedId);
	}
	
	
	//회원가입 기능
	@PostMapping(value="/users/signup")
	public String postSignup(UsersVO vo,RedirectAttributes rttr) throws Exception{

		service.signup(vo);
		return "redirect:/";
	}
	
	
	//로그인 기능
	@PostMapping(value="/users/signin")
	public String postSignin(UsersVO vo,HttpServletRequest req,RedirectAttributes rttr) throws Exception{
		UsersVO login=service.signin(vo);
		if(login!=null) {
			if(vo.getUserPw().equals(login.getUserPw())) {
				UsersVO userinfo=service.viewUserInfo(vo);
				HttpSession session=req.getSession();
				session.setAttribute("userinfo",userinfo);
				return "redirect:/";
			}else {
				
				rttr.addFlashAttribute("message","등록하신 정보와 맞지 않습니다");
				return "redirect:/users/signin";
			}
		}
		
		rttr.addFlashAttribute("message","아이디가 없습니다");
		return "redirect:/users/signin";
	}
	
	
	//로그아웃
	@GetMapping(value="/logout")
	public String getLogout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:/";
	}

	
	//아이디 찾기
	@GetMapping(value="/users/findid")
	public void getFindid() throws Exception{
	}
	
	@PostMapping(value="/users/findid/phone")
	public String postFindidByPhone(UsersVO vo, RedirectAttributes rttr) throws Exception{
	    String userId = service.findidByPhone(vo);
	    
	    rttr.addFlashAttribute("userId", userId);
	    
	    return "redirect:/users/findidresult";
	}

	@PostMapping(value="/users/findid/email")
	public String postFindidByEmail(UsersVO vo, RedirectAttributes rttr) throws Exception{
	    String userId = service.findidByEmail(vo);
	    
	    rttr.addFlashAttribute("userId", userId);
	    
	    return "redirect:/users/findidresult";
	}
	
	@GetMapping(value = "/users/findidresult")
	public String getFindidResult(Model model) {
		
		String userId = (String) model.getAttribute("userId");
		
	    model.addAttribute("userId", userId);
	    
		return "/users/findidresult";
	}
	
	//비밀번호찾기
	@GetMapping(value="/users/findpw")
	public void getFindpw() throws Exception{
	}
	
	@PostMapping(value="/users/findpw")
	public String postFindpw(UsersVO vo, RedirectAttributes rttr) throws Exception{
		
		String email = service.findpw(vo);
		
		 if (email != null && !email.isEmpty()) {
	            // 이메일 보내기
	            boolean isMailSent = Utils.sendMail(email, vo.getUserId());
		 }
		
		rttr.addFlashAttribute("email", email);
		
		return "redirect:/users/findpwresult";
	}
	
	@GetMapping(value="/users/findpwresult")
	public String getFindpwResult(Model model) {
		
		String email= (String) model.getAttribute("email");
		
		model.addAttribute("email",email);
		return "/users/findpwresult";
	}
	
	//메일로 비밀번호 찾기사이트에 userId 전송
	@GetMapping("/users/reset-password")
	public String getResetPassword(@RequestParam("userId") String userId, Model model) {
	    model.addAttribute("userId", userId);
	    return "/users/resetpw";
	}
	
	@PostMapping("/users/reset-password")
	public String postResetPassword(@RequestParam("userId") String userId,
	                                 @RequestParam("userPw") String userPw,
	                                 @RequestParam("userPwRe") String userPwRe,
	                                 RedirectAttributes rttr) throws Exception {

	    if (userId.contains(",")) {
	        userId = userId.split(",")[0];
	    }
	    
	    if (!userPw.equals(userPwRe)) {
	        rttr.addFlashAttribute("message", "비밀번호가 일치하지 않습니다.");
	        return "redirect:/users/reset-password?userId=" + userId;
	    }

	    // 비밀번호 변경 로직 (service를 통해 비밀번호 업데이트)
	    boolean isUpdated = service.updatePw(userId, userPw, userPwRe);

	    if (isUpdated) {
	        rttr.addFlashAttribute("message", "비밀번호가 성공적으로 변경되었습니다.");
	        return "redirect:/users/signin";  // 로그인 페이지로 리다이렉트
	    } else {
	        rttr.addFlashAttribute("message", "비밀번호 변경에 실패했습니다.");
	        return "redirect:/users/reset-password?userId=" + userId;  // 다시 시도
	    }
	}
}
