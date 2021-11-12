package com.care.root.controller;

import java.net.http.HttpRequest;
import java.sql.Date;
import java.util.Calendar;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.care.root.common.session.MemberSessionName;
import com.care.root.dto.MemberDTO;
import com.care.root.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController implements MemberSessionName{
	@Autowired MemberService ms;
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	@PostMapping("/user_check")
	public String userCheck(
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam(required = false) String autoLogin,
			RedirectAttributes rs
			) {
		System.out.println("autoLogin"+autoLogin);
		int result = ms.userCheck(id,pw);
		if(result == 0) {
			rs.addAttribute("id", id);
			rs.addAttribute("autoLogin", autoLogin);
			return "redirect:successLogin";
		}
		return "redirect:login";
	}
	@GetMapping("/successLogin")
	public String successLogin(
			@RequestParam String id,
			@RequestParam(required = false) String autoLogin,
			HttpSession session,
			HttpServletResponse response
			) {
		if(autoLogin != null) {
			int limitTime = 60*60*25*90; // 90일
			Cookie loginCookie = new Cookie("loginCookie",session.getId());
			loginCookie.setMaxAge(limitTime);
			loginCookie.setPath("/"); //최상위에서 사용하겠다
			response.addCookie(loginCookie);
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(new java.util.Date());
			cal.add(Calendar.MONTH, 3); // 월에서 3개월 나중으로 수정해주세요
			
			java.sql.Date limitDate = new java.sql.Date(cal.getTimeInMillis());
			ms.keepLogin(session.getId(), limitDate, id);
		}
		session.setAttribute(LOGIN, id);
		
		return "member/successLogin";
	}
	@GetMapping("logout")
	public String logout(
			HttpSession session,
			HttpServletResponse response,
			@CookieValue(value="loginCookie", required=false) Cookie loginCookie
			) {
		if(session.getAttribute(LOGIN) != null) {
			if(loginCookie != null) {
				loginCookie.setMaxAge(0);
				loginCookie.setPath("/");
				response.addCookie(loginCookie);
				System.out.println(loginCookie.getValue());
				ms.keepLogin("nan",new java.sql.Date(System.currentTimeMillis()), (String)session.getAttribute(LOGIN));
			}
			session.invalidate();
			
			
		}
		return "redirect:/index";
	}
	@GetMapping("memberInfo")
	public String memberInfo(Model model, HttpSession session) {
		//if(session.getAttribute(LOGIN) != null) {
			ms.memberInfo(model);
			return "member/memberInfo";
		//}else
		//	return "redirect:login";

	}
	@GetMapping("info")
	public String info(@RequestParam String id, Model model) {
		ms.getMember(id,model);
		return "member/info";
	}
	@GetMapping("register_form")
	public String registerForm() {
		return "member/register";
	}
	@PostMapping("register")
	public String register(MemberDTO dto) {
		int result = ms.register(dto);
		if(result == 1) {
			return "redirect:login";
		}
		return "redirect:register_form";
	}
}
