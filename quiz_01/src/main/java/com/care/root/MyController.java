package com.care.root;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping(value="index")
	public ModelAndView memberIndex() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("index","기본 페이지 입니다.");
		mv.setViewName("member/index");
		return mv;
	}
	@RequestMapping(value="login")
	public ModelAndView memberLogin() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("login","로그인 페이지 입니다.");
		mv.setViewName("member/login");
		return mv;
	}
	@RequestMapping(value="logout")
	public ModelAndView memberLogout() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("logout","로그아웃 페이지 입니다.");
		mv.setViewName("member/logout");
		return mv;
	}
}
