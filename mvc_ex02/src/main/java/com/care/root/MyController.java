package com.care.root;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	// url 경로 localhost:port/root/index
	@RequestMapping(value="index")
	public String memberIndex() {
		// .jsp 파일의 경로
		return "member/index";
	}
	@RequestMapping("logout")
	public String memberLogout(Model model) {
		String db = "디비에서 데이터를 가져왔습니다";
		model.addAttribute("key",db);
		model.addAttribute("ok","로그아웃 되었습니다");
		
		return "/member/logout";
	}
	@RequestMapping("login")
	public ModelAndView memberLogin() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("login","로그인 성공하였습니다");
		mv.setViewName("member/login");
		return mv;
	}
}
