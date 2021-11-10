package com.care.root.mybatis.member;

import java.util.ArrayList;

import com.care.root.dto.MemberDTO;

public interface MemberMapper {
	public MemberDTO getMember(String id);
	public ArrayList<MemberDTO> memberInfo();
	public int register(MemberDTO dto);
}
