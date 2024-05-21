package org.capgemini.blue_harvest.transactionservice.exception;

import org.capgemini.blue_harvest.transactionservice.constant.TransactionConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnknownException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(TransactionConstants.UNEXPECTED_ERROR_MESSAGE + e.getMessage());
    }

	
	
    
}