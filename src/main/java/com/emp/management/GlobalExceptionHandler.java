
package com.emp.management;

import com.emp.management.exception.EmployeeNotFoundException;
import com.emp.management.exception.EmployeeResponse;
import com.emp.management.exception.FailedDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = {EmployeeNotFoundException.class,
                               FailedDataException.class})
    public ResponseEntity<EmployeeResponse> handleGenericNotFoundException(Exception e) {
        EmployeeResponse error = new EmployeeResponse("101",e.getMessage(),404);

        error.setStatus((HttpStatus.NOT_FOUND.value()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
