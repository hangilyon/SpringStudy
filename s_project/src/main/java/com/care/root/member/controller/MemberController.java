package com.care.root.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired MemberService ms;
	
	@GetMapping("index")
	public String main() {
		return "default/main";
	}
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	@PostMapping("loginChk")
	public void loginChk(MemberDTO dto, 
			HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int chk = ms.loginChk(dto);
		if(chk == 1) {
			session.setAttribute("loginId", dto.getId());
			out.print("<script> alert('로그인 성공'); "
					+ "location.href='successLogin';</script>");
		}else if(chk == 0) {
			out.print("<script> alert('비밀번호가 틀렸습니다.'); "
					+ "location.href='login';</script>");
		}else {
			out.print("<script> alert('아이디가 없습니다.'); "
					+ "location.href='login';</script>");
		}
	}
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
	@RequestMapping("successLogin")
	public String successLogin() {
		return "member/successLogin";
	}
	@GetMapping("memberinfo")
	public String memberinfo(Model model) {
		ArrayList<MemberDTO> list = ms.memberinfo();
		model.addAttribute("list", list);
		return "member/memberinfo";
	}
	@GetMapping("info")
	public String info(Model model, MemberDTO dto) {
		MemberDTO userInfo = ms.userInfo(dto);
		model.addAttribute("userInfo", userInfo);
		return "member/info";
	}
	@GetMapping("register")
	public String register() {
		return "member/register";
	}
	@PostMapping("insertMem")
	public void insertMem(MemberDTO dto,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int chk = ms.insertMem(dto);
		System.out.println(chk);
		if(chk == 1 ) {
			out.print("<script> alert('회원가입 성공'); "
					+ "location.href='login';</script>");
		}else {
			out.print("<script> alert('회원가입 실패'); "
					+ "location.href='register';</script>");
		}
	}
}
