package com.southwind.repository;

import java.util.Collection;

import com.southwind.entity.Student;

public interface StudentRepository {
	public Collection<Student> findAll(); //返回全部的数据
	
	public Student findById(Long id);//提供ID去返回数据
	
	public void saveOrUpadate(Student student);//添加或是修改
	
	public void deleteById(Long Id);//删除
	
}
