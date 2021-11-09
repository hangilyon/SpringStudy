package com.care.root.member.service;



import java.util.ArrayList;

import com.care.root.member.dto.MemberDTO;


public interface MemberService {
	public int loginChk(MemberDTO dto);
	public ArrayList<MemberDTO> memberinfo();
	public MemberDTO userInfo(MemberDTO dto);
	public int insertMem(MemberDTO dto);
}
