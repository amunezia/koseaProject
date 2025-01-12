package com.kosea.project.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kosea.project.vo.UsersVO;

public class QnaInterceptor implements HandlerInterceptor{
	private static final Logger logger=LoggerFactory.getLogger(QnaInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse rttr, Object obj) throws Exception{
		HttpSession session=req.getSession();
		UsersVO userinfo=(UsersVO) session.getAttribute("userinfo");
		
		return false;
	}
}
