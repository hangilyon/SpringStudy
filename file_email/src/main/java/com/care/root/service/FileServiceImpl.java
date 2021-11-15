package com.care.root.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.dto.ShoesDTO;
import com.care.root.mybatis.FileMapper;

@Service
public class FileServiceImpl implements FileService{
	@Autowired FileMapper fm;
	@Override
	public void fileProcess(MultipartHttpServletRequest mul) {
		// TODO Auto-generated method stub
		ShoesDTO dto = new ShoesDTO();
		dto.setId(mul.getParameter("id"));
		dto.setName(mul.getParameter("name"));
		
		MultipartFile file = mul.getFile("file");
		if(file.getSize() != 0) { //if(!file.isEmpty())
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar calendar = Calendar.getInstance();
			String sysFileName = fo.format(calendar.getTime());
			sysFileName += file.getOriginalFilename();
			File saveFile = new File(IMAGE_REPO + "/" + sysFileName);
			dto.setImgName(sysFileName);
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			dto.setImgName("non");
		}
		fm.saveData(dto);
	}
	@Override
	public void getData(Model model) {
		// TODO Auto-generated method stub
		model.addAttribute("list", fm.getData());
	}

}
