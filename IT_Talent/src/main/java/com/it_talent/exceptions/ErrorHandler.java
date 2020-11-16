package com.it_talent.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	
   public ResponseEntity<ErrorMessages> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		// obtener los errores de spring
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        
        // convertir errores a string
        StringBuilder errorMessage = new StringBuilder();
        for (FieldError f: fieldErrors) {
        	if (!f.getDefaultMessage().isEmpty()) {
        		errorMessage.append(f.getDefaultMessage());
        		errorMessage.append(" / ");
        	}
        }
    
        // retorna objeto de error en formato json
        ErrorMessages errorMessages = new ErrorMessages(errorMessage.toString().trim());
		
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
   }
	
}
