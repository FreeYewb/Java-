package com.southwind.controller;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RespectBinding;

import org.apache.catalina.tribes.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.southwind.entity.User;
import com.southwind.entity.UserList;
/**
 * 
* <p>Title: DateBindHandler</p>  
* <p>Description: </p>  
* @author yewenbo
* @date 2019年11月29日
 */
@RestController
@RequestMapping("/data")
public class DateBindHandler {
	
	//基本数字类型
	@RequestMapping("/baseType")
	//@ResponseBody
	public String baseType(int id) {
		return id+"";
	}
	
	//包装类
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
	
	@RequestMapping("/list")
	public String lits(UserList list,HttpServletResponse response) {
		response.setContentType("text/json=UTF-8");
		StringBuffer str = new StringBuffer();
		for(User user : list.getUsers()) {
			str.append(user);
		}
		return str.toString();
	}
}
