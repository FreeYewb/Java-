package com.southwind.controller;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
		Student student = new Student();
		student.setAge(22);
		student.setId(1L);
		student.setName("撒水水");
		modelAndView.addObject("student",student);
		return modelAndView;
	}
	
	@GetMapping("/get2")
	public ModelAndView get2() {
		ModelAndView modelAndView = new ModelAndView("tag");
		
		Student student = new Student(1L, "撒水水", 22,true,null,null,0,0,null);
		Student student2 = new Student(2L, "撒水", 33,false,null,null,0,0,null);
		String[] hobby = {"a","2","3","4","5","a6","a7"};
		
//		student.setHobby(hobby);
		student.setHobby(Arrays.asList("s宿舍s","ss","aw","sxf"));
		student2.setHobby(Arrays.asList("a","2","ss","4"));
		student2.setSelectHobby(Arrays.asList("a","2","ss","4","5","a6","a7"));
		student2.setRadioId(1);
		Map<Integer,String> map = new HashMap<Integer, String>();
		map.put(1, "1连");
		map.put(2, "2连");
		map.put(3, "3连");
		map.put(4, "4连");
		map.put(5, "5连");
		student.setGradeMap(map);
		student.setSelectGrade(3);
		//student2.setSelectHobby();

		modelAndView.addObject("student",student);
		modelAndView.addObject("student2",student2);
		return modelAndView;
	}
}
