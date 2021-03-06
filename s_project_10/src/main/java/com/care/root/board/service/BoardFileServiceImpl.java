package com.care.root.board.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BoardFileServiceImpl implements BoardFileService{

	@Override
	public String getMessage(HttpServletRequest request, String msg, String url) {
		// TODO Auto-generated method stub
		String message = null;
		String path = request.getContextPath();
		message = "<script>alert('"+msg+"');";
		message += "location.href='"+path+url+"';</script>";
		return message;
	}

	@Override
	public String saveFile(MultipartFile file) {
		// TODO Auto-generated method stub
		SimpleDateFormat simpl = new SimpleDateFormat("yyyyMMddHHmmss-");
		Calendar calendar = Calendar.getInstance();
		String sysFileName = 
				simpl.format(calendar.getTime()) + file.getOriginalFilename();
		File saveFile = new File(IMAGE_REPO+"/"+sysFileName);
		try {
			file.transferTo(saveFile);//해당 위치에 파일 저장
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sysFileName;
	}

	@Override
	public void deleteImage(String originFileName) {
		// TODO Auto-generated method stub
		File deleteFile = new File(IMAGE_REPO+"/"+originFileName);
		deleteFile.delete();
	}


}
