package com.southwind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HellospringController2 {
	String mm = "欢迎光临";
	@RequestMapping("/index2")
	public String index() {
		System.out.println("到达第二步");
		return mm;
	}
}
