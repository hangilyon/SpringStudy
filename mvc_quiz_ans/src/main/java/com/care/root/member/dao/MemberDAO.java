package com.care.root.member.dao;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.care.root.member.dto.MemberDTO;

@Repository
public class MemberDAO {
	private ArrayList<MemberDTO> dbList;
	public MemberDAO() {
		System.out.println("dao 실행");
		dbList = new ArrayList<MemberDTO>();
	}
	public void register(MemberDTO dto) {
		dbList.add(dto);
		System.out.println("디비에 등록 완료");
	}
	public ArrayList<MemberDTO> memberList() {
		// String sql = "select * from table";
		return dbList;
	}
	public int loginCheck(String id, String pwd) {
		int check = -1;
		for(int i=0;i<dbList.size();i++) {
			if(dbList.get(i).getId().equals(id)) {
				System.out.println("아이디 맞음");
				if(dbList.get(i).getPwd().equals(pwd)) {
					System.out.println("비밀번호 맞음");
					check = 1;
				}else {
					System.out.println("비밀번호 틀림");
					check = 0;
				}
			}else {
				System.out.println("아이디 틀림");
				check = -1;
			}
		}
		return check;
	}
	public MemberDTO MemberInfo(String id) {
		for(int i=0;i<dbList.size();i++) {
			if(dbList.get(i).getId().equals(id)) {
				System.out.println(dbList.get(i));
				return dbList.get(i);
			}
		}
		return null;
	}
}