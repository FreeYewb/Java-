package com.southwind.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileHandler {

	@PostMapping("/upload")	
	public String upload(MultipartFile img,HttpServletRequest request) {
		System.out.println(img);
		if (img.getSize()>0) {
			//获取保存上传文件的file路径
			String path = request.getServletContext().getRealPath("file");
			System.out.println(path);
			//获取上传的文件名
			String name = img.getOriginalFilename();
			System.out.println(name);
			File file = new File(path,name);
		try {
			img.transferTo(file);
			//保存上传之后的文件路径
			request.setAttribute("path","/file/"+name);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		return "upload";
		
	}
	
	@PostMapping("/uploads")
	public String uploads(MultipartFile[] imgs,HttpServletRequest request) {
		List<String> files = new ArrayList<>();
		for(MultipartFile img: imgs) {
			if(img.getSize()>0) {
				String path = request.getServletContext().getRealPath("file");
				String name = img.getOriginalFilename();
				File file = new File(path,name);
				
				try {
					img.transferTo(file);
					files.add("/file/"+name);
				} catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		request.setAttribute("files", files);
		
		return "uploads";
		
	}
	
}
