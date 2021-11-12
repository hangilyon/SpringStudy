package com.care.root.member.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.care.root.common.session.MemberSessionName;
import com.care.root.dto.MemberDTO;
import com.care.root.service.MemberService;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter implements MemberSessionName{
	@Autowired MemberService ms;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("auto login execute");
		/*// for문으로 쿠키 찾아오는 방법
		for(Cookie c : request.getCookies()) {
			if(c.getName().equals("loginCookie")) {
				
			}
		}
		*/
		// 없으면 null , 있으면 쿠키값이 들어옴!
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		if(loginCookie != null) {
			MemberDTO dto = ms.getUserSessionId(loginCookie.getValue());
			if(dto != null) {
				//HttpSession session = request.getSession();
				//session.setAttribute(LOGIN,dto.getId());
				request.getSession().setAttribute( LOGIN , dto.getId());
			}
		}
		return true;
	}
}
