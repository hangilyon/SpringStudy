package com.care.root.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired MemberMapper mapper;
	@Override
	public int loginChk(MemberDTO dto) {
		// TODO Auto-generated method stub
		MemberDTO mem = mapper.loginChk(dto); 
		if(mem == null) {
			System.out.println("아이디없음");
			return -1;
		}else if(mem.getPw().equals(dto.getPw())) {
			System.out.println("비밀번호맞음");
			return 1;
		}else {
			System.out.println("비밀번호 틀림");
			System.out.println(mem.getPw());
			System.out.println(dto.getPw());
			return 0;
		}
	}
	@Override
	public ArrayList<MemberDTO> memberinfo() {
		// TODO Auto-generated method stub
		ArrayList<MemberDTO> list = mapper.memberinfo();
		return list;
	}
	@Override
	public MemberDTO userInfo(MemberDTO dto) {
		// TODO Auto-generated method stub
		MemberDTO userInfo = mapper.loginChk(dto);
		return userInfo;
	}
	@Override
	public int insertMem(MemberDTO dto) {
		// TODO Auto-generated method stub
		try {
			int chk = mapper.insertMem(dto);
			return chk;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
