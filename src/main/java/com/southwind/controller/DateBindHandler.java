package com.southwind.controller;

import javax.xml.ws.RespectBinding;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 
* <p>Title: DateBindHandler</p>  
* <p>Description: </p>  
* @author yewenbo
* @date 2019��11��29��
 */
@Controller
@RequestMapping("/data")
public class DateBindHandler {
	
	//������������
	@RequestMapping("/baseTyepe")
	@ResponseBody
	public String baseType(int id) {
		return id+"";
	}
	
	//��װ��
	@ResponseBody
	@RequestMapping("/PackageTyepe")
	public String PackageTyepe(Integer id) {
		return id+"";
	}
}
