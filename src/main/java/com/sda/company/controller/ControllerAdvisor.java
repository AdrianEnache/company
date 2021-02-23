package com.sda.company.controller;

import com.sda.company.exception.CompanyException;
import com.sda.company.exception.DepartmentException;
import com.sda.company.exception.EmployeeException;
import com.sda.company.exception.ProjectException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CompanyException.class)
    public ResponseEntity<Object> handleCompanyException(CompanyException exception) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("errorMessage", exception.getLocalizedMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_ACCEPTABLE);

    }

    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<Object> handleCompanyException(EmployeeException exception) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("errorMessage", exception.getLocalizedMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_ACCEPTABLE);

    }

    @ExceptionHandler(DepartmentException.class)
    public ResponseEntity<Object> handleCompanyException(DepartmentException exception) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("errorMessage", exception.getLocalizedMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_ACCEPTABLE);

    }

    @ExceptionHandler(ProjectException.class)
    public ResponseEntity<Object> handleCompanyException(ProjectException exception) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("errorMessage", exception.getLocalizedMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_ACCEPTABLE);

    }
}
