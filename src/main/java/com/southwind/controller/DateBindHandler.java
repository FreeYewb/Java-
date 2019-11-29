package com.southwind.controller;

import javax.xml.ws.RespectBinding;

import org.apache.catalina.tribes.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
* <p>Title: DateBindHandler</p>  
* <p>Description: </p>  
* @author yewenbo
* @date 2019��11��29��
 */
@RestController
@RequestMapping("/data")
public class DateBindHandler {
	
	//������������
	@RequestMapping("/baseType")
	//@ResponseBody
	public String baseType(int id) {
		return id+"";
	}
	
	//��װ��
	//@ResponseBody
	@RequestMapping("/PackageType")
	public String PackageTyepe(@RequestParam(value = "num" ,required = false,defaultValue="0")Integer id) {
		return id+"";
	}
	//@ResponseBody
	@RequestMapping("/array")
	public String array(String[] name) {
		String str = Arrays.toString(name);
		return str;
	}
}
