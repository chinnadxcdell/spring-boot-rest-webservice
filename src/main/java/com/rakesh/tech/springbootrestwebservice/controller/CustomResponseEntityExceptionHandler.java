package com.rakesh.tech.springbootrestwebservice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		System.out.println("calling global exception..................");
		ResponseException responseException = new ResponseException(new Date(),
														ex.getMessage(), request.getDescription(false));
			
		
		return new ResponseEntity<Object>(responseException,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<Object> studentException(Exception ex, WebRequest request) throws Exception {
		System.out.println("calling student not found exception..................");
		ResponseException responseException = new ResponseException(new Date(),
														ex.getMessage(), request.getDescription(false));
			
		
		return new ResponseEntity<Object>(responseException,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(NullPointerException.class)
	public final ResponseEntity<Object> studentNullException(Exception ex, WebRequest request) throws Exception {
		System.out.println("calling student not found exception..................");
		ResponseException responseException = new ResponseException(new Date(),
														ex.getMessage(), request.getDescription(false));
			
		
		return new ResponseEntity<Object>(responseException,HttpStatus.BAD_REQUEST);
	}
	
	
	 @Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("Calling......validations method..............");
		 List<String> errors = new ArrayList<String>();
		 List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		 
		 for(FieldError error : fieldErrors) {
			 errors.add(error.getDefaultMessage());
		 }
		 
		 Map<String,Object> map = new LinkedHashMap<String,Object>();
		 map.put("timeStamp", new Date());
		 map.put("status", status.value());
		 map.put("errors", errors);
		 
		 
		return new ResponseEntity<Object>(map,headers,status);
	}
	
	
}
