package com.southwind.controller;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.southwind.entity.User;
/**
 * 
* <p>Title: HelloHandler</p>  
* <p>Description: </p>  
* @author yewenbo
* @date 2019年11月29日
 */
@Controller
@RequestMapping("/hello")
public class HelloHandler {
	@RequestMapping(value="/index", method = RequestMethod.GET,params= {"name","id"})
	public String index(@PathParam("name")String name, int id) {
		System.out.println("执行index");
		System.out.println(name);
		System.out.println(id);
		return "index";
		}
	@RequestMapping("/rest/{name}/{id}")
	public String rest(@PathVariable("name")String name,@PathVariable("id") int id) {
		System.out.println(name);
		System.out.println(id);
		return "index";
	}
	@RequestMapping("/cookie")
	public String cookie(@CookieValue(value="JSESSIONID") String sessionId) {
		System.out.println(sessionId);
		return "index";
	}
	@RequestMapping(value="/save", method =RequestMethod.POST)
	public String save(User user) {
		System.out.println(user);
		return "index";
		
	}
	//转发
	@RequestMapping("/forward")
	public String fowrd() {
		return "forward:/index.jsp";
	}
	//重定向
	@RequestMapping("redirect")
	public  String redirect() {
		return "redirect:/index.jsp";
	}
}
