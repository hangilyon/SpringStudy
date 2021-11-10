package com.care.root.service;

import org.springframework.ui.Model;

import com.care.root.dto.MemberDTO;

public interface MemberService {
	public int userCheck(String id, String pw);
	public void memberInfo(Model model);
	public void getMember(String id, Model model);
	public int register(MemberDTO dto);
}
