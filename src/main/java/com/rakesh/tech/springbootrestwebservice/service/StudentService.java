package com.rakesh.tech.springbootrestwebservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakesh.tech.springbootrestwebservice.beans.Student;
import com.rakesh.tech.springbootrestwebservice.dao.StudentDao;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public List<Student> getAllStudents()
	{
		return studentDao.getAllStudents();
	}
	
	public Student createStudent(Student student)
	{
		return studentDao.createStudent(student);
	}
	
	
	public Student getStudent(int studentId) {
		return studentDao.getStudent(studentId);
	}
}
