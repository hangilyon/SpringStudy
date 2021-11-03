package com.care.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.member.dao.MemberDAO;
import com.care.member.dto.MemberDTO;

@Controller
public class MemberController {
	@Autowired
	MemberDAO dao;
	// 메인화면
	@RequestMapping("/index")
	public String index() {
		return "member/index";
	}
	// 회원가입란
	@RequestMapping("/insert")
	public String insert() {
		return "member/insertView";
	}
	// 모든 회원 보기
	@RequestMapping("/memberView")
	public String memberView() {
		return "member/memberVIew";
	}
	// 회원가입
	@RequestMapping("/insertMember")
	public String insertMember(MemberDTO dto, Model model) {
		System.out.println(dto);
		dao.inputMem(dto);
		return "member/index";
	}
}
