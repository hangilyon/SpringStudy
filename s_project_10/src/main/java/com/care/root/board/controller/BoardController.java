package com.care.root.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.service.BoardFileService;
import com.care.root.board.service.BoardService;
import com.care.root.common.session.MemberSessionName;
import com.care.root.mybatis.board.BoardMapper;

@Controller
@RequestMapping("board")
public class BoardController implements MemberSessionName{
	@Autowired BoardService bs;
	@Autowired BoardFileService bfs;
	@GetMapping("boardAllList")
	public String boardAllList(Model model){
		bs.boardAllList(model);
		return "board/boardAllList";
	}
	@GetMapping("writeForm")
	public String writeForm() {
		return "board/writeForm";
	}
	@PostMapping("writeSave")
	public void writeSave(
			MultipartHttpServletRequest mul,
	        HttpServletResponse response,
	        HttpServletRequest request) throws IOException {
	   String message = bs.writeSave(mul, request);
	   PrintWriter out=null;
	   response.setContentType("text/html; charset=utf-8");
	   out = response.getWriter();
	   out.println(message);
	}
	@GetMapping("contentView")
	public String contentView(
			@RequestParam int writeNo,
			Model model) {
		bs.contentView(writeNo,model);
		return "board/contentView";
	}

	@GetMapping("download")
	public void download(
			@RequestParam("imageFileName") String imageFileName,
			HttpServletResponse response) throws IOException {
		response.addHeader(
				"Content-disposition","attachment;fileName="+imageFileName);
		File file = new File(bfs.IMAGE_REPO+"/"+imageFileName);
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, response.getOutputStream());
		fis.close();
	}
	@GetMapping("modify_form")
	public String modifyForm(@RequestParam int writeNo, Model model) {
		System.out.println("writeNo : "+writeNo);
		bs.getData(writeNo, model);
		return "board/modify_form";
	}
	@PostMapping("modify")
	public void modify(MultipartHttpServletRequest mul,
			HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		String message = bs.modify(mul, request);
		PrintWriter out=null;
		response.setContentType("text/html; charset=utf-8");
		out = response.getWriter();
		out.println(message);
	}

}
