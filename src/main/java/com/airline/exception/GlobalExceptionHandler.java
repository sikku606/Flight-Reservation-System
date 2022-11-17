package com.airline.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.airline.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> map = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> { 
			String fieldName = ((FieldError) error).getField(); 
			String message = error.getDefaultMessage();
			
			map.put(fieldName, message);

		});

		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RecordNotFoundException.class)

	public ResponseEntity<ApiResponse> resourceNotfoundExceptionhandler(RecordNotFoundException ex) {
		String messsage = ex.getMessage();
		
		ApiResponse apiResponse = new ApiResponse(messsage, false);
		
		return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
		

	}
	
	@ExceptionHandler(RecordAlreadyPresentException.class)

	public ResponseEntity<ApiResponse> resourceNotfoundExceptionhandler(RecordAlreadyPresentException ex) {
		String messsage = ex.getMessage();
		
		ApiResponse apiResponse = new ApiResponse(messsage, false);
		
		return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
		

	}

}