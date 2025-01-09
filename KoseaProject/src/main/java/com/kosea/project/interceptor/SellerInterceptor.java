package com.kosea.project.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kosea.project.vo.UsersVO;

public class SellerInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(SellerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		HttpSession session = req.getSession();
		UsersVO users = (UsersVO)session.getAttribute("userinfo");
		
		if(users==null) {
			 logger.warn("미로그인 사용자에 의한 액세스 검출: " + req.getRequestURI());
			 res.sendRedirect("/users/signin");
			 return false;
		}
		if(users.getVerify() !=5) {
			logger.warn("판매자가 아닌 유저가 접근하였습니다."+users.getUserId());
			res.sendRedirect("/");
			return false;
		}
		return true;
	}
}
