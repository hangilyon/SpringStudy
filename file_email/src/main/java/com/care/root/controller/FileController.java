package com.care.root.controller;

import java.io.File;
import java.io.FileInputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.care.root.service.FileService;

@Controller
public class FileController {
	@Autowired FileService fs;
	@GetMapping("form")
	public String form() {
		return "uploadForm";
	}
	@PostMapping("upload")
	public String upload(MultipartHttpServletRequest mul) {
		/*
		System.out.println(mul.getParameter("id"));
		System.out.println(mul.getParameter("name"));
		
		MultipartFile file = mul.getFile("file");
		
		System.out.println(file.getOriginalFilename());
		*/
		fs.fileProcess(mul);
		return "redirect:form";
	}
	@GetMapping("views")
	public String views(Model model) {
		fs.getData(model);
		return "result";
	}
	
	@GetMapping("download")
	public void download(
			@RequestParam("file") String fileName,
			HttpServletResponse response ) throws Exception {
		// Content-disposition : 파일로 응답 하겠다
		// attachment : 파일을 웹브라우저로 표현해 주겠다
		// fileName : 다운로드할 이름
		response.addHeader("Content-disposition", 
				"attachment; fileName="+fileName);
		File file = new File(FileService.IMAGE_REPO + "/" + fileName);
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, response.getOutputStream());
	}
}
