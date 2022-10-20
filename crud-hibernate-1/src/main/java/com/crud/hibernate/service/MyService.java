package com.crud.hibernate.service;

import java.util.List;

import com.crud.hibernate.entity.Student;

public interface MyService{
	
	public List<Student> getAllStudent();
	
	public Student getStudentById(int id);
	
	public Student addStudent(Student student);
	
	public Student modifyStudent(Student student);
	
	public void deleteStudentById(int id);
	
	
	
	
	

}
