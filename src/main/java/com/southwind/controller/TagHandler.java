package com.southwind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.southwind.entity.Student;

@Controller
@RequestMapping("/tag")
public class TagHandler {
	@GetMapping("/get")
	public ModelAndView get() {
		ModelAndView modelAndView = new ModelAndView("show");
		Student student = new Student(1L, "撒水水", 22);
		modelAndView.addObject("student",student);
		return modelAndView;
	}
	
	@GetMapping("/get2")
	public ModelAndView get2() {
		ModelAndView modelAndView = new ModelAndView("tag");
		Student student = new Student(1L, "撒水水", 22);
		Student student2 = new Student(2L, "撒水", 33);
		modelAndView.addObject("student",student);
		modelAndView.addObject("student2",student2);
		return modelAndView;
	}
}
