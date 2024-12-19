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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kosea.project.service.UsersService;
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
				
				rttr.addFlashAttribute("msg",0);
				return "redirect:/signin";
			}
		}
		
		rttr.addFlashAttribute("msg",-1);
		return "redirect:/signin";
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
		
		UsersVO user = service.findpw(vo);
		
		rttr.addFlashAttribute("user", user);
		
		return "redirect:/users/findpwselect";
	}
	
	@GetMapping(value="/users/findpwselect")
	public String getFindpwSelect(Model model) {
		
		UsersVO user = (UsersVO) model.getAttribute("user");
		
		model.addAttribute("user",user);
		return "/users/findpwselect";
	}

}
