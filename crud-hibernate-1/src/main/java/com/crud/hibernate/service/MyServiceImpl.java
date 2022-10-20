package com.crud.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.hibernate.customexception.BusinessException;
import com.crud.hibernate.entity.Student;
import com.crud.hibernate.repo.StudentRepo;
@Service
public class MyServiceImpl implements MyService {
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public List<Student> getAllStudent() {
		try {
			List<Student> listOfStudents = studentRepo.findAll();
			if (listOfStudents.isEmpty()) 
				throw new BusinessException("600", "Opps! There is not data in database to be displayed");
				return listOfStudents;
		} catch(Exception e) {
			throw new BusinessException("601", "Opps! Something went wrong in service layer while fetching employees" + e.getMessage());
		}
	}

	
	@Override
	public Student getStudentById(int id) {
		return studentRepo.findById(id).get();
	}

	@Override
	public Student addStudent(Student student) {
		try {
			if (student.getName().isEmpty() || student.getName().length() == 0) {
				throw new BusinessException("602", "Please enter a valid Student name, It is null");
			}
			Student newStudent = studentRepo.save(student);
			return newStudent;
		} catch (IllegalArgumentException e) {
			throw new BusinessException("603", "Given employee is null" + e.getMessage());
		}

	}

	@Override
	public Student modifyStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public void deleteStudentById(int id) {		
		 studentRepo.deleteById(id);
	}
	
	

}
