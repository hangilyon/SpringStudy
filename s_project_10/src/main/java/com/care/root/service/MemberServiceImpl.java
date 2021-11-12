package com.care.root.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired MemberMapper mapper;
	BCryptPasswordEncoder encoder;
	public MemberServiceImpl() {
		encoder = new BCryptPasswordEncoder();
	}
	@Override
	public int userCheck(String id, String pw) {
		// TODO Auto-generated method stub
		MemberDTO dto = mapper.getMember(id);
		if(dto != null) {
			//if(pw.equals(dto.getPw())) {
			if(encoder.matches(pw, dto.getPw())||pw.equals(dto.getPw())) {
				return 0;
			}
		}
		return 1;
		
	}
	@Override
	public void memberInfo(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("memberList", mapper.memberInfo());
	}
	@Override
	public void getMember(String id, Model model) {
		model.addAttribute("getMember", mapper.getMember(id));
		// TODO Auto-generated method stub
		
	}
	@Override
	public int register(MemberDTO dto) {
		// TODO Auto-generated method stub
		System.out.println("변경 전 : "+dto.getPw());
		String securePw = encoder.encode(dto.getPw());
		System.out.println("변경 후 : "+securePw);
		
		dto.setPw(securePw);
		int result = 0;
		try {
			result = mapper.register(dto);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	@Override
	public void keepLogin(String sessionId, Date limitDate, String id) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("sessionId", sessionId);
		map.put("limitDate",limitDate);
		map.put("id", id);
		mapper.keepLogin(map);
	}
	@Override
	public MemberDTO getUserSessionId(String sessionId) {
		// TODO Auto-generated method stub
		MemberDTO dto = mapper.getUserSessionId(sessionId);
		if(dto != null) {
			return dto;
		}
		return null;
	}

}
