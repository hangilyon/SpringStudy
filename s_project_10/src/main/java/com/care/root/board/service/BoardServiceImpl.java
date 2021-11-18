package com.care.root.board.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.dto.BoardDTO;
import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired BoardMapper mapper;
	@Autowired BoardFileService bfs;
	@Override
	public void boardAllList(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("boardList", mapper.boardAllList());
	}
	// 글쓰기 db에 등록
	@Override
	public String writeSave(
			MultipartHttpServletRequest mul, 
	        HttpServletRequest request) {
		// TODO Auto-generated method stub
		BoardDTO dto = new BoardDTO();
		dto.setTitle( mul.getParameter("title"));
		dto.setContent( mul.getParameter("content"));
		dto.setId(mul.getParameter("id"));

		MultipartFile file = mul.getFile("image_file_name");
		if(file.getSize() != 0) {
			//이미지 있을경우 처리
			dto.setImageFileName(bfs.saveFile(file));
		}else {
			dto.setImageFileName("nan");
		}
		int result = 0;
		String msg, url;
		try{
			result = mapper.writeSave(dto);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(result == 1) {
			msg = "새 글이 추가되었습니다";
			url = "/board/boardAllList";
		}else {
			msg = "문제가 발생되었습니다!!!";
			url = "/board/writeForm";
		}
		return bfs.getMessage(request, msg, url);
	}
	@Override
	public void contentView(int writeNo, Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("personalData",mapper.contentView(writeNo));
		upHit(writeNo);
		
	}
	public void upHit(int writeNo) {
		mapper.upHit(writeNo);
	}
	@Override
	public void getData(int writeNo, Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("personalData", mapper.getData(writeNo));
	}
	@Override
	public String modify(MultipartHttpServletRequest mul, HttpServletRequest request) {
		// TODO Auto-generated method stub
		BoardDTO dto = new BoardDTO();
		dto.setWriteNo( Integer.parseInt(mul.getParameter("writeNo")) );
		dto.setTitle(mul.getParameter("title"));
		dto.setContent(mul.getParameter("content"));

		MultipartFile file = mul.getFile("imageFileName");
		if(file.getSize() != 0 ) {
			//이미지 변경시
			dto.setImageFileName(bfs.saveFile(file));
			bfs.deleteImage(mul.getParameter("originFileName"));
		}else {
			dto.setImageFileName(mul.getParameter("originFileName"));
		}
		int result = mapper.modify(dto);
		String msg, url;
		if(result == 1) {
			msg = "성공적으로 수정되었습니다";
			url = "/board/boardAllList";
		}else {
			msg = "수정 중 문제가 발생하였습니다";
			url = "/board/modify_form";
		}
		String message = bfs.getMessage(request, msg, url);
		return message;
	}
}
