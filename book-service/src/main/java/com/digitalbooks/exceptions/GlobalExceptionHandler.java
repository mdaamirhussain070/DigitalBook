package com.digitalbooks.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.digitalbooks.utility.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFound ex){
		
		ApiResponse apiresponse=new ApiResponse();
		apiresponse.setResource(ex.getResourceName());
		apiresponse.setFieldName(ex.getFieldName());
		apiresponse.setFieldValue(ex.getFieldValue());
		
	return new ResponseEntity<>(apiresponse,HttpStatus.NOT_FOUND);
		
	}
	
	

}
