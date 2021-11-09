package com.care.root.member.mybatis.member;

import java.util.ArrayList;

import com.care.root.member.dto.MemberDTO;

public interface MemberMapper {
	public MemberDTO loginChk(MemberDTO dto);
	public ArrayList<MemberDTO> memberinfo();
	public int insertMem(MemberDTO dto);
}
