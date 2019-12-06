package com.southwind.controller;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RespectBinding;

import org.apache.catalina.tribes.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.southwind.entity.User;
import com.southwind.entity.UserList;
import com.southwind.entity.UserMap;
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
	public String array(String[] name,Integer[] id) {
		String str = Arrays.toString(name);
		str = str+Arrays.toString(id);
		return str;
	}
	
	@RequestMapping(value="/list")
	public String lits(UserList list) {
		
		StringBuffer str = new StringBuffer();
		for(User user : list.getUsers()) {
			str.append(user);
		}
		return str.toString();
	}
	@RequestMapping("/map")
	public String map(UserMap usermap) {
		StringBuffer str = new StringBuffer();
		for(String key: usermap.getUsers().keySet()) {
			User user = usermap.getUsers().get(key);
			str.append(user);
		}
		return str.toString();
	}
	
	@RequestMapping("/json")
	public User json(@RequestBody User user) {
		user.setId(22);
		user.setName("sa的撒");
		return user;
	}
}
