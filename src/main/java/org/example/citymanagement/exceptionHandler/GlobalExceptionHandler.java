package org.example.citymanagement.exceptionHandler;

import org.example.citymanagement.exception.PersonNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<String> personNotFound(PersonNotFoundException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
