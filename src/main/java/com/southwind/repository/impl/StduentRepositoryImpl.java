package com.southwind.repository.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.southwind.entity.Student;
import com.southwind.repository.StudentRepository;

@Repository //把这个类交给IOC
public class StduentRepositoryImpl implements StudentRepository{

	private static Map<Long, Student> studentMap;
	
	static {
		studentMap = new HashMap<Long, Student>();
		studentMap.put(1L,new Student(1,"张",22));
		studentMap.put(2L,new Student(2,"全",23));
		studentMap.put(3L,new Student(3,"蛋",24));
	}
	
	@Override
	public Collection<Student> findAll() {
		// TODO Auto-generated method stub
		return studentMap.values();
	}

	@Override
	public Student findById(Long id) {
		// TODO Auto-generated method stub
		return studentMap.get(id);
	}

	@Override
	public void saveOrUpadate(Student student) {
		// TODO Auto-generated method stub
		studentMap.put(student.getId(), student);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		studentMap.remove(id);
	}

}
