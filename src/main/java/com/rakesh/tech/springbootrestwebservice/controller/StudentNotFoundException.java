package com.rakesh.tech.springbootrestwebservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException{

		public StudentNotFoundException(String msg) {
			super(msg);
		}
}
