package com.southwind.controller;


import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.southwind.entity.Student;
import com.southwind.repository.StudentRepository;
@RestController
@RequestMapping("/rest")
public class RESTHandler {
	@Autowired
	private StudentRepository repository;
	
	//@RequestMapping(value="/findall",method = RequestMethod.GET)
	@GetMapping("/findall")
	public Collection<Student> findAll(HttpServletResponse response){
		response.setContentType("text/json;charset=UTF-8");
		return repository.findAll();
	}
	
	@GetMapping("/findbyid/{id}")
	public Student findById(@PathVariable("id") long id,HttpServletResponse response) {
		response.setContentType("text/json;charset=UTF-8");
		return repository.findById(id);
	}
	
	@PostMapping("/save")
	public void save(@RequestBody Student student) {
	repository.saveOrUpadate(student);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Student student) {
		repository.saveOrUpadate(student);
	}
	@DeleteMapping("/deleteById/{id}")
	public void delete(@PathVariable("id") long id) {
		repository.deleteById(id);
		
	}
}
