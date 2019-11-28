package com.southwind.controller;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloHandler {
	@RequestMapping(value="/index", method = RequestMethod.GET,params= {"name","id"})
	public String index(@PathParam("name")String name, int id) {
		System.out.println("Ö´ÐÐindex");
		System.out.println(name);
		System.out.println(id);
		return "index";
		}
	@RequestMapping("/rest/{name}/{id}")
	public String rest(@PathVariable("name")String name,@PathVariable("id") int id) {
		System.out.println(name);
		System.out.println(id);
		return "rest";
	}
}
