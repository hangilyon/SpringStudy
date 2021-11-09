package com.care.root.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	// 연산은 서비스쪽에서 담당한다.
	@Autowired MemberDAO mapper;
	@Override
	public void insert(MemberDTO dto) {
		// TODO Auto-generated method stub
		mapper.insert(dto);
	}
	@Override
	public void memberview(Model model) {
		// TODO Auto-generated method stub
		ArrayList<MemberDTO> list = mapper.memberview();
		model.addAttribute("list",list);
	}

}
