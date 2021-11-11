package com.care.root.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
public class BoardController {
	@GetMapping("/index")
	public String index(){
		System.out.println("실행");
		return "board/index";
	}
}
