package com.care.root.member.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired MemberService ms;
	public MemberController() {
		System.out.println("컨트롤러 실행");
	}
	@RequestMapping("test")
	public void test() {
		System.out.println("ms : "+ms); 
		ms.test();
	}
	@GetMapping("/index")
	public String memberIndex() {
		return "member/index";
	}
	@GetMapping("register_view")
	public String registerView() {
		return "member/register_view";
	}
	@GetMapping("member_list")
	public String memberList(Model model) {
		//ArrayList<MemberDTO> list = ms.memberList();
		//model.addAttribute("list",list);
		ms.memberList(model);
		return "member/member_list";
	}
	@PostMapping("register")
	public String register(MemberDTO dto) {
		System.out.println("register 연결 확인");
		// 서비스이동 -> dao 이동
		System.out.println(dto.getId());
		System.out.println(dto.getName());
		System.out.println(dto.getPwd());
		
		return "redirect:/member/index";
	}
	
	@PostMapping("register1")
	public String register1(HttpServletRequest req) {
		System.out.println("register 연결 확인");
		// 서비스이동 -> dao 이동
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("pwd"));
		System.out.println(req.getParameter("name"));
		
		return "redirect:/member/index";
	}
	@PostMapping("register2")
	public String register2(@RequestParam("id") String id,
							@RequestParam String name,
							@RequestParam String pwd) {
		System.out.println("register 연결 확인");
		// 서비스이동 -> dao 이동
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(name);
		
		ms.register(id,pwd,name);
		
		return "redirect:/member/index";
	}
	@PostMapping("login")
	public String login(@RequestParam("id") String id,
						@RequestParam("pwd") String pwd,
						RedirectAttributes ra) {
		int check = ms.login(id, pwd);
		if(check==1) {
			ra.addFlashAttribute("member",ms.MemberInfo(id));
			return "redirect:/member/main";

			
		}else {
			ra.addFlashAttribute("result",check);
			return "redirect:/member/index";
		}
	}
	@RequestMapping("main")
	public String main() {
		return "member/main";
	}
	@RequestMapping("memberInfo_view")
	public String memberInfo_view(@RequestParam("id") String id, Model model) {
		System.out.println(id);
		MemberDTO dto = ms.MemberInfo(id);
		System.out.println(dto);
		model.addAttribute("dto",dto);
		return "member/memberInfo_view";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
