package com.southwind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HellospringController2 {
	String mm = "��ӭ����";
	@RequestMapping("/index2")
	public String index() {
		System.out.println("����ڶ���");
		return mm;
	}
}
