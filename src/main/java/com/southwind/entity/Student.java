package com.southwind.entity;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	private long id;
	private String name;
	private int age;
	private boolean flag;
	private List<String> hobby;
	private List<String> selectHobby;
	private int radioId;
	private int selectGrade;
	private Map<Integer, String> gradeMap;
	
	

	public Student(long id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}



	
}
