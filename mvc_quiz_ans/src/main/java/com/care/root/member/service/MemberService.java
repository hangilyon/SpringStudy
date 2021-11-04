package com.care.root.member.service;

import org.springframework.ui.Model;

import com.care.root.member.dto.MemberDTO;

public interface MemberService {
	public void test();
	public void register(String id,String pwd,String name);
	public void memberList(Model model);
	public int login(String id, String pwd);
	public MemberDTO MemberInfo(String id);
}
