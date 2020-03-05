package com.rakesh.tech.springbootrestwebservice.beans;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Student {
	
	private int studentId;
	@Size(min=3,message="Name should not be less than 3 characters.......")
	private String studentName;
	private String studentCourse;
	@Past(message="Date should not be future.....")  // @Future ( dob will not be in future )
	private Date dateOfBirth;
	
	
	public Student(int studentId, String studentName, String studentCourse, Date dateOfBirth) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentCourse = studentCourse;
		this.dateOfBirth = dateOfBirth;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentCourse() {
		return studentCourse;
	}
	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentCourse=" + studentCourse
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	

}
