package com.kosea.project.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kosea.project.vo.UsersVO;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		HttpSession session = req.getSession();
		UsersVO users = (UsersVO)session.getAttribute("userinfo");
		
		if(users==null) {
			 logger.warn("未ログインユーザーによるアクセスを検出: " + req.getRequestURI());
			 res.sendRedirect("/users/signin");
			 return false;
		}
		if(users.getVerify() !=9) {
			logger.warn("관리자 권한이 없는 유저가 접근하려함"+users.getUserId());
			res.sendRedirect("/");
			return false;
		}
		return true;
	}
}
