package com.care.root.board.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface BoardFileService {
	public static final String IMAGE_REPO = "C:\\IMAGE_REPO";
	public String getMessage(
			HttpServletRequest request, 
			String msg, 
			String url);
	public String saveFile(MultipartFile file);
	public void deleteImage(String originFileName);
}
