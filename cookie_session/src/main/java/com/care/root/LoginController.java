package com.care.root;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@RequestMapping("login")
	public String login() {
		return "login/login";
	}
	@PostMapping("chkUser")
	public String shkUser(
			@RequestParam String id,
			@RequestParam String pwd,
			HttpSession session) {
		String DB_id = "1", DB_pwd="1", DB_nick="홍길동구리구리";
		if(DB_id.equals(id) && DB_pwd.equals(pwd)) {
			session.setAttribute("loginId", id);
			session.setAttribute("loginNick", DB_nick);
			
			return "redirect:main";
		}else {
			return "redirect:login";
		}
	}
	@RequestMapping("main")
	public String main() {
		return "login/main";
	}
	/*
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("loginId") != null) {
			System.out.println("로그인 성공인 사람은 로그아웃");
			session.invalidate();
		}else {
			System.out.println("로그인 없는 사람 로그아웃");
		}
		return "login/logout";
	}
	*/
	@RequestMapping("logout")
	public void logout(
			HttpSession session,
			HttpServletResponse response ) {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(session.getAttribute("loginId") != null) {
			System.out.println("로그인 성공한 사람은 로그아웃");
			session.invalidate();
			out.print("<script> alert('로그아웃 성공'); "
					+ "location.href='login';</script>");
		}else {
			System.out.println("로그인 없는 사람 로그아웃");
			out.print("<script>alert('로그인 먼저 진행');"
					+ "location.href='login';</script>");
		}
	}
}
