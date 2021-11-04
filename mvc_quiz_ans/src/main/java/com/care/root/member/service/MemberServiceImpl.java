package com.care.root.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired MemberDAO dao;
	public MemberServiceImpl() {
		System.out.println("서비스 실행");
	}
	public void test() {
		System.out.println("dao : "+dao);
	}
	@Override
	public void register(String id, String pwd, String name) {
		// TODO Auto-generated method stub
		MemberDTO dto = new MemberDTO();
		dto.setId(id); dto.setPwd(pwd); dto.setName(name);
		dao.register(dto);
	}
	@Override
	public void memberList(Model model) {
		// TODO Auto-generated method stub
		//ArrayList<MemberDTO> list = dao.memberList();
		//model.addAttribute("list",list);
		model.addAttribute("list",dao.memberList());
	}
	public int login(String id, String pwd) {
		int check = dao.loginCheck(id,pwd);
		return check;
	}
	@Override
	public MemberDTO MemberInfo(String id) {
		// TODO Auto-generated method stub
		return dao.MemberInfo(id);
	}
}
