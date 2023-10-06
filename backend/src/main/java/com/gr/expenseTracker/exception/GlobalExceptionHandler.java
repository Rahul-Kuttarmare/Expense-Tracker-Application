package com.gr.expenseTracker.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler{
	
	
	@ExceptionHandler(UserExistException.class)
	public ResponseEntity<Object> userExistException(UserExistException ex,WebRequest request){
		ErrorModel errormodel = new ErrorModel(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(errormodel, HttpStatus.BAD_REQUEST);
	}
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	   public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		   
		   Map<String,String> resp = new HashMap<>();
		   		ex.getBindingResult().getAllErrors().forEach((error)->{
		   			String fieldname = ((FieldError)error).getField();
		   			String message = error.getDefaultMessage();
		   			resp.put(fieldname, message);
		   		});
	       return new ResponseEntity<Map<String,String>>(resp , HttpStatus.BAD_REQUEST);
	                           
	   }
}
