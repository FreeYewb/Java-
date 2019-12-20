package com.southwind.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.southwind.entity.Student;
@RestController
@RequestMapping("/converter")
public class ConverterHandler {
	@RequestMapping("/date")
	public String Date(Date date) {
		return date.toString();
	}
	
	@RequestMapping("/student")
	public String Student(Student student) {
		return student.toString();
	}
	
}
