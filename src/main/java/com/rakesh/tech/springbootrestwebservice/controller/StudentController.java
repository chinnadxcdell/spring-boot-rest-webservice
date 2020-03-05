package com.rakesh.tech.springbootrestwebservice.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rakesh.tech.springbootrestwebservice.beans.Student;
import com.rakesh.tech.springbootrestwebservice.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	// URL : http://localhost:2020/getAllStudents
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents(){
		return new ResponseEntity<List<Student>>(studentService.getAllStudents(),HttpStatus.OK);
	}
	
	// URL : http://localhost:2020/createStudent
	
	//@PostMapping("/createStudent")
	@RequestMapping(value="/createStudent",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createStudent(@Valid @RequestBody Student student)
	{
		Student stu = studentService.createStudent(student);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{studentId}").buildAndExpand(stu.getStudentId()).toUri();
		return  ResponseEntity.created(location).build();
		
	}

	
	@GetMapping("/getStudent/{studentId}")
	public ResponseEntity<Student> getStudent(@PathVariable int studentId) {
		Student student = studentService.getStudent(studentId);
		if(student==null)
			throw new  StudentNotFoundException("Student Not Found : "+studentId);
		else
			return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
}
