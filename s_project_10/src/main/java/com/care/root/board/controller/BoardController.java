package com.care.root.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.care.root.common.session.MemberSessionName;

@Controller
@RequestMapping("board")
public class BoardController implements MemberSessionName{
	@GetMapping("/contentView")
	public String index(){
		System.out.println("실행");
		return "board/contentView";
	}
	@GetMapping("/writeForm")
	public String writeForm() {
		return "board/writeForm";
	}
}
