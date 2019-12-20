package com.southwind.converter;

import org.springframework.core.convert.converter.Converter;

import com.southwind.entity.Student;

public class StudentConverter implements Converter<String, Student>{
	


	@Override
	public Student convert(String arg0) {
		
		String[] strings = arg0.split(",");
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setId(Long.parseLong(strings[0]));
		student.setName(strings[1]);
		student.setAge(Integer.parseInt(strings[2]));
		return student;
	}
	
}
