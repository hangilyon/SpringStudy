package com.care.root.common.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.care.root.common.session.MemberSessionName;

public class CommonInterceptor extends HandlerInterceptorAdapter implements MemberSessionName{

	@Override
	// 컨트롤 전에 실행
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("컨트롤러 실행 전전전");
		HttpSession session = request.getSession();
		if(session.getAttribute(LOGIN) == null) {
			//response.sendRedirect("/root/member/login");
			response.setContentType("text/html; charset = utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>"
					+ "alert('로그인 해라잉~~~');"
					//+ "location.href='/root/member/login;'"
					+ "location.href='"+request.getContextPath()+"/member/login;'"
					+ "</script>");
			return false;
		}
		return true;
	}

	@Override
	// 컨트롤이 끝난 다음에 실행
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("컨트롤러 실행 후후후");
	}
}
