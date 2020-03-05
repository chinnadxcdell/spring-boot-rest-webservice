package com.rakesh.tech.springbootrestwebservice.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rakesh.tech.springbootrestwebservice.beans.Student;

@Repository
public class StudentDao {
	
	private static List<Student> allStudentsList = new ArrayList<Student>();
	
	static {
		allStudentsList.add(new Student(100,"Srikanth","Java",new Date()));
		allStudentsList.add(new Student(200,"Rakesh",".Net",new Date()));
	}
	
	public List<Student> getAllStudents(){
		return allStudentsList;
	}

	
	public Student createStudent(Student student) {
		allStudentsList.add(student);
		return student;
	}
	
	public Student getStudent(int studentId)
	{
		 for(Student student : allStudentsList) {
			 if(student.getStudentId()==studentId) {
				 return student;
			 }
		 }
		 return null;
	}
	
	
	
	
}
