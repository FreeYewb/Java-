package com.southwind.repository;

import java.util.Collection;

import com.southwind.entity.Student;

public interface StudentRepository {
	public Collection<Student> findAll(); //����ȫ��������
	
	public Student findById(Long id);//�ṩIDȥ��������
	
	public void saveOrUpadate(Student student);//��ӻ����޸�
	
	public void deleteById(Long Id);//ɾ��
	
}
