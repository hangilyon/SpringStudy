package com.care.root;

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
			session.setAttribute("loginID", id);
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
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login/logout";
	}
}
