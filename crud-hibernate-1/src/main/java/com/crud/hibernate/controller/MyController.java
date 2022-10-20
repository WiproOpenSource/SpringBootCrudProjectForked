package com.crud.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.hibernate.customexception.BusinessException;
import com.crud.hibernate.customexception.ControllerException;
import com.crud.hibernate.entity.Student;
import com.crud.hibernate.service.MyService;



@RestController
public class MyController {
	
	@Autowired
	private MyService myService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAllStudent() {
			List<Student> listOfStudents = myService.getAllStudent();
			return new ResponseEntity<List<Student>>(listOfStudents, HttpStatus.OK);		
	}
	
	@GetMapping("/getAll/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") int id) {
		try {
			Student studentById = myService.getStudentById(id);
			return new ResponseEntity<Student>(studentById, HttpStatus.OK);	
		}catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessgae());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);		
		}catch (Exception e) {
			ControllerException ce = new ControllerException("604","Something went wromg in Controller layer");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/addStudent")
	public ResponseEntity<?> addStudent(@RequestBody Student student){
		try {
			Student studentById = myService.addStudent(student);
			return new ResponseEntity<Student>(studentById, HttpStatus.CREATED);
		}catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(),e.getErrorMessgae());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);		
		}catch (Exception e) {
			ControllerException ce = new ControllerException("605","Something went wromg in Controller layer");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/modifyStudent")
	public ResponseEntity<Student> modifyStudent(@RequestBody Student student){
		Student studentById = myService.modifyStudent(student);
		return new ResponseEntity<Student>(studentById, HttpStatus.CREATED);	
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<Void> deleteByStudent(@PathVariable("id") int id){
		myService.deleteStudentById(id);
		return new ResponseEntity<Void>(HttpStatus.CREATED);	
	}

}
